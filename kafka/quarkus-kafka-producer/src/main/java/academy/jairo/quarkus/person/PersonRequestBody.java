package academy.jairo.quarkus.person;

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
