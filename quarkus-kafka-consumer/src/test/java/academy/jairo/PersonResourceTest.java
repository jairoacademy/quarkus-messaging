package academy.jairo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
class PersonResourceTest {

    @Test
    void testGetAll() {

        given()
                .when().get("/person")
                .then()
                .body("size()", equalTo(0))
                .statusCode(Response.Status.OK.getStatusCode());

    }

    @Test
    void testGetAllByRequest() {

        given()
                .when().get("/person/byRequest")
                .then()
                .body("size()", equalTo(0))
                .statusCode(Response.Status.OK.getStatusCode());

    }

}
