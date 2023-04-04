package academy.jairo.quarkus.activemq.consumer.client;

import com.google.common.base.MoreObjects;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Client extends PanacheEntity {

    public String name;

    public String flag;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("flag", flag)
                .toString();
    }

}
