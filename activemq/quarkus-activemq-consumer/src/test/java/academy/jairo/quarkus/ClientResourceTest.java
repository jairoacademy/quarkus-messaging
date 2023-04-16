package academy.jairo.quarkus;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class ClientResourceTest {

    @Test
    void testGetAll() {

        given()
                .when().get("/client")
                .then()
                .body("size()", equalTo(0))
                .statusCode(Response.Status.OK.getStatusCode());

    }

    @Test
    void testGetAllByRequest() {

        given()
                .when().get("/client/request")
                .then()
                .body("size()", equalTo(0))
                .statusCode(Response.Status.OK.getStatusCode());

    }

}
