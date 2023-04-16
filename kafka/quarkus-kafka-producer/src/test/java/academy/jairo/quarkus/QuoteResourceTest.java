package academy.jairo.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.reactive.messaging.providers.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.providers.connectors.InMemorySink;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
class QuoteResourceTest {

    @Inject
    Logger log;

    @Inject
    @Any
    InMemoryConnector connector;

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchOutgoingChannelsToInMemory("quote-topic");
    }

    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }

    @Test
    void testCreateClientBodyEndpoint() {

        given()
                .when().get("/quote/request")
                .then()
                .body(containsString("UUID:"))
                .statusCode(Response.Status.CREATED.getStatusCode());

        InMemorySink<String> queue = connector.sink("quote-topic");
        assertNotNull(queue.received().get(0).getPayload());

        log.infof("> payload: %s", queue.received().get(0).getPayload());

    }

    @Test
    void testStream() {

        given()
                .when().get("/quote/stream")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .contentType(MediaType.SERVER_SENT_EVENTS);

    }
}