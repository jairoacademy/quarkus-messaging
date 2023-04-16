package academy.jairo.quarkus.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import io.vertx.core.json.JsonObject;

import java.util.Objects;

public class ClientRequestBody {

    @JsonIgnore
    public String id;

    public String name;

    public String flag;

    @JsonIgnore
    public String foo;

    public static ClientRequestBody of(JsonObject jsonRequestBody) {
        Objects.requireNonNull(jsonRequestBody, "a JsonObject is required");
        return jsonRequestBody.mapTo(ClientRequestBody.class);
    }

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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("flag", flag)
                .toString();
    }

}
