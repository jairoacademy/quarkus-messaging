package academy.jairo;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySink;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
class ClientResourceTest {

    @Inject
    Logger log;

    @Inject
    @Any
    InMemoryConnector connector;

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchOutgoingChannelsToInMemory("string-channel");
        InMemoryConnector.switchOutgoingChannelsToInMemory("json-channel");
    }

    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }

    @Test
    void testCreateMessagingEndpoint() {

        given()
                .when().get("/client/createMessaging")
                .then()
                .statusCode(200)
                .body(containsString("UUID:"));

        InMemorySink<String> queue = connector.sink("string-channel");
        String payload = queue.received().get(0).getPayload();
        log.infof("> payload: %s", payload);

    }

    @Test
    void testCreateClientBodyEndpoint() {

        given()
                .when().get("/client/createClientBody")
                .then()
                .body("name", containsString("NinjaMan"))
                .statusCode(Response.Status.OK.getStatusCode());

        InMemorySink<String> queue = connector.sink("json-channel");
        log.infof("> payload: %s", queue.received().get(0).getPayload());

    }
}