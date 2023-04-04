package academy.jairo.quarkus.kafka.consumer.quote;

public class Quote {

    public String id;

    public int price;

    public Quote(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", price=" + price +
                '}';
    }
    
}
