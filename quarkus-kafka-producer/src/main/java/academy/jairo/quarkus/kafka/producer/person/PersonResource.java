package academy.jairo.quarkus.kafka.producer.person;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.UUID;

@Path("/person")
public class PersonResource {

    private final Random random = new Random();

    @Channel("person-topic")
    Emitter<PersonRequestBody> emitter;

    @GET
    @Path("/createPerson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRequest() {
        UUID uuid = UUID.randomUUID();
        var n = random.nextInt(100);
        PersonRequestBody personRequestBody = PersonRequestBody.of(
                uuid.toString(),
                String.format("NinjaMan %s", n), String.format("ninjaman%s@gmail.com", n));
        emitter.send(personRequestBody);
        return Response.ok(personRequestBody).build();
    }

}
