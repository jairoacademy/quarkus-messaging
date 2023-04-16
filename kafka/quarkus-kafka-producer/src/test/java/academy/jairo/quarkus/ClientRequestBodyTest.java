package academy.jairo.quarkus;

import academy.jairo.quarkus.client.ClientRequestBody;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class ClientRequestBodyTest {

    @Test
    void testEquals() {
        ClientRequestBody obj1 = new ClientRequestBody();
        obj1.id = "1";
        obj1.name = "Client1";
        obj1.flag = "active";

        ClientRequestBody obj2 = new ClientRequestBody();
        obj2.id = "1";
        obj2.name = "Client1";
        obj2.flag = "active";

        assertEquals(obj1, obj2);
        assertEquals(obj1.hashCode(), obj2.hashCode());

        obj2.flag = "inactive";

        assertNotEquals(obj1, obj2);
        assertNotEquals(obj1.hashCode(), obj2.hashCode());
    }

}