package academy.jairo.quarkus.kafka.consumer.client;

import com.google.common.base.MoreObjects;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Client extends PanacheEntity {

    public String name;

    public String flag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(flag, client.flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, flag);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("flag", flag)
                .toString();
    }

}
