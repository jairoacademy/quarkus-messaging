package academy.jairo;

import academy.jairo.quarkus.kafka.consumer.client.Client;
import academy.jairo.quarkus.kafka.consumer.person.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@QuarkusTest
class PersonTest {

    @Inject
    Logger log;

    @Test
    void testEquals() {
        Person obj1 = new Person();
        obj1.id = 1L;
        obj1.name = "Person1";
        obj1.email = "active@gmail.com";

        Person obj2 = new Person();
        obj2.id = 1L;
        obj2.name = "Person1";
        obj2.email = "active@gmail.com";

        assertEquals(obj1, obj2);

        assertEquals(obj1.hashCode(), obj2.hashCode());

        obj2.email = "inactive@gmail.com";

        assertNotEquals(obj1, obj2);

        assertNotEquals(obj1.hashCode(), obj2.hashCode());

        String expectedObj1ToString ="Person{id=1, name=Person1, email=active@gmail.com}";

        assertEquals(expectedObj1ToString, obj1.toString());
    }
}
