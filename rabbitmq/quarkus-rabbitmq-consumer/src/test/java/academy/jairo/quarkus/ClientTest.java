package academy.jairo.quarkus;

import academy.jairo.quarkus.client.Client;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@QuarkusTest
class ClientTest {

    @Inject
    Logger log;

    @Test
    void testEquals() {
        Client obj1 = new Client();
        obj1.id = 1L;
        obj1.name = "Client1";
        obj1.flag = "active";

        Client obj2 = new Client();
        obj2.id = 1L;
        obj2.name = "Client1";
        obj2.flag = "active";

        assertEquals(obj1, obj2);

        assertEquals(obj1.hashCode(), obj2.hashCode());

        obj2.flag = "inactive";

        assertNotEquals(obj1, obj2);

        assertNotEquals(obj1.hashCode(), obj2.hashCode());

        log.infof("kkk > expectedObj1ToString %s:", obj1.toString());
        String expectedObj1ToString ="Client{id=1, name=Client1, flag=active}";

        assertEquals(expectedObj1ToString, obj1.toString());
    }
}
