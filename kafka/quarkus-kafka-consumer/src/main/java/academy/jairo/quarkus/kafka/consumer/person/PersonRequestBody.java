package academy.jairo.quarkus.kafka.consumer.person;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public class PersonRequestBody {

    private String id;

    private String name;

    private String email;

    public PersonRequestBody(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static PersonRequestBody of(String id, String name, String email) {
        return new PersonRequestBody(id, name, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRequestBody that = (PersonRequestBody) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("email", email)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
