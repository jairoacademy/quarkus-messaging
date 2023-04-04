package academy.jairo;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySink;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySource;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Any;
import javax.inject.Inject;

@QuarkusTest
class ConsumerProcessorStringChannelTest {

    @Inject
    Logger log;

    @Inject
    @Any
    InMemoryConnector connector;

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchIncomingChannelsToInMemory("string-topic");
        InMemoryConnector.switchOutgoingChannelsToInMemory("out-topic");
    }

    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }

    @Test
    void process() {

        InMemorySource<String> inChanel = connector.source("string-topic");

        InMemorySink<Integer> results = connector.sink("out-topic");

        inChanel.send("Hi broker!");

        log.infof("> received: %s", results.received());

        Assertions.assertEquals(0, results.received().size());

    }


}