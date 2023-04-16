package academy.jairo.quarkus;

import academy.jairo.quarkus.person.PersonRequestBody;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        PersonRequestBody person2 = new PersonRequestBody("2", "Jane", "jane@example.com");

        assertEquals(person, person2);
        person2.setEmail("jane2@example.com");

        assertNotEquals(person.hashCode(), person2.hashCode());

        String expectedObj1ToString ="PersonRequestBody{id=2, name=Jane, email=jane2@example.com}";

        assertEquals(expectedObj1ToString, person2.toString());

    }

    @Test
    void testOfMethod() {
        PersonRequestBody person = PersonRequestBody.of("1", "John", "john@example.com");
        assertEquals("1", person.getId());
        assertEquals("John", person.getName());
        assertEquals("john@example.com", person.getEmail());
    }

}