package academy.jairo.quarkus.kafka.producer.client;

import java.util.Objects;

public class ClientRequestBody {

    public String id;

    public String name;

    public String flag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientRequestBody that = (ClientRequestBody) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, flag);
    }
}
