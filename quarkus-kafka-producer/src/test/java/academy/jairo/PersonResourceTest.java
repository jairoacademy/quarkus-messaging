package academy.jairo;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
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
class PersonResourceTest {

    @Inject
    Logger log;

    @Inject
    @Any
    InMemoryConnector connector;

    @BeforeAll
    public static void switchMyChannels() {
        InMemoryConnector.switchOutgoingChannelsToInMemory("person-topic");
    }

    @AfterAll
    public static void revertMyChannels() {
        InMemoryConnector.clear();
    }

    @Test
    void testCreatePersonEndpoint() {

        given()
                .when().get("/person/createPerson")
                .then()
                .contentType(ContentType.JSON)
                .body("name", containsString("NinjaMan"))
                .statusCode(Response.Status.OK.getStatusCode());

        InMemorySink<String> queue = connector.sink("person-topic");
        log.infof("> payload: %s", queue.received().get(0).getPayload());

    }
}