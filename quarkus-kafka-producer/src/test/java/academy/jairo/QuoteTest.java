package academy.jairo;

import academy.jairo.quarkus.kafka.producer.quote.Quote;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class QuoteTest {

    @Test
    void testConstructorAndGetters() {
        String id = "123";
        int price = 100;
        Quote quote = new Quote(id, price);
        assertEquals(id, quote.id);
        assertEquals(price, quote.price);
    }

    @Test
    void testToString() {
        String id = "456";
        int price = 200;
        Quote quote = new Quote(id, price);
        String expected = "Quote{id='" + id + "', price=" + price + "}";
        assertEquals(expected, quote.toString());
    }

}