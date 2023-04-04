package academy.jairo.quarkus.rabbitmq.producer.client;

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
    Emitter<String> emitterClient;

    @Channel("json-channel")
    Emitter<JsonObject> emitterClientRequestBody;

    private Random random = new Random();

    @GET
    @Path("createMessaging")
    @Produces(MediaType.TEXT_PLAIN)
    public String createMessaging() {

        UUID uuid = UUID.randomUUID();
        String message = "UUID: " + uuid.toString();
        emitterClient.send(message);

        return message;
    }

    @GET
    @Path("createClientBody")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createClientBody() {

        UUID uuid = UUID.randomUUID();
        int i = random.nextInt(100);
        ClientRequestBody clientRequestBody = new ClientRequestBody();
        clientRequestBody.id = uuid.toString();
        clientRequestBody.name = "NinjaMan " + i;
        clientRequestBody.flag = "Abc " + i;
        emitterClientRequestBody.send(JsonObject.mapFrom(clientRequestBody));
        return Response.ok(clientRequestBody).build();

    }

}
