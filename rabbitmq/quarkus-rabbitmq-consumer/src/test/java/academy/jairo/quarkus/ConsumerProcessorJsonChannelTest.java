package academy.jairo.quarkus;

import academy.jairo.quarkus.client.ClientRequestBody;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySink;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySource;
import io.vertx.core.json.JsonObject;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

@QuarkusTest
class ConsumerProcessorJsonChannelTest {

    @Inject
    Logger log;

    @Inject
    @Any
    InMemoryConnector connector;

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchIncomingChannelsToInMemory("json-channel");
        InMemoryConnector.switchOutgoingChannelsToInMemory("out-channel");
    }

    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }

    @Test
    void processClientBody() {

        InMemorySource<JsonObject> inChanel = connector.source("json-channel");

        InMemorySink<JsonObject> results = connector.sink("out-channel");

        ClientRequestBody client = new ClientRequestBody();
        client.id = "1";
        client.name = "NinjaMan ";
        client.flag = "Abc ";
        inChanel.send(JsonObject.mapFrom(client));

        log.infof("> received: %s", results.received());
        Assertions.assertEquals(0, results.received().size());

    }

}