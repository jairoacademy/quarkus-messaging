package academy.jairo;

import academy.jairo.quarkus.kafka.producer.person.PersonRequestBody;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class PersonRequestBodyTest {

    @Test
    void testGettersAndSetters() {
        PersonRequestBody person = new PersonRequestBody("1", "John", "john@example.com");
        assertEquals("1", person.getId());
        assertEquals("John", person.getName());
        assertEquals("john@example.com", person.getEmail());

        person.setId("2");
        person.setName("Jane");
        person.setEmail("jane@example.com");
        assertEquals("2", person.getId());
        assertEquals("Jane", person.getName());
        assertEquals("jane@example.com", person.getEmail());
    }

    @Test
    void testOfMethod() {
        PersonRequestBody person = PersonRequestBody.of("1", "John", "john@example.com");
        assertEquals("1", person.getId());
        assertEquals("John", person.getName());
        assertEquals("john@example.com", person.getEmail());
    }

}