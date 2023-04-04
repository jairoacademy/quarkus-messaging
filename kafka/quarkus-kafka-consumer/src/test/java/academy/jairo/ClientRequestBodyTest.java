package academy.jairo;

import academy.jairo.quarkus.kafka.consumer.client.ClientRequestBody;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


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

        String expectedObj1ToString ="ClientRequestBody{id=1, name=Client1, flag=active}";

        assertEquals(expectedObj1ToString, obj1.toString());
    }

}