package academy.jairo.quarkus.activemq.producer.quarkus.activemq.producer.client;

import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Random;
import java.util.UUID;

@Path("/client")
public class ClientResource {

    @Channel("string-channel")
    Emitter<String> emitterString;

    @Channel("json-channel")
    Emitter<JsonObject> emitterJson;

    private final Random random = new Random();

    @GET
    @Path("createMessaging")
    @Produces(MediaType.TEXT_PLAIN)
    public String createMessaging() {

        UUID uuid = UUID.randomUUID();
        String message = "UUID: " + uuid.toString();
        emitterString.send(message);

        return message;
    }

    @GET
    @Path("createClientBody")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClientBody() {

        UUID uuid = UUID.randomUUID();
        int i = random.nextInt(100);
        ClientRequestBody client = new ClientRequestBody();
        client.id = uuid.toString();
        client.name = "NinjaMan " + i;
        client.flag = "Abc " + i;
        emitterJson.send(JsonObject.mapFrom(client));
        return Response.ok(client).build();

    }

}
