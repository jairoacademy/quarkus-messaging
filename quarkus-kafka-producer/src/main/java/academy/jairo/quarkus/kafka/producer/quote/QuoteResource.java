package academy.jairo.quarkus.kafka.producer.quote;

import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/quote")
public class QuoteResource {

    @Channel("quotes")
    Multi<Quote> quotes;

    @Channel("quote-topic")
    Emitter<String> emitter;

    @GET
    @Path("/request")
    @Produces(MediaType.TEXT_PLAIN)
    public Response createRequest() {
        UUID uuid = UUID.randomUUID();
        String message = "UUID: ".concat(uuid.toString());
        // quarkus-kafka-consumer project waiting for this at quote-topic
        //    and that has a @Outgoing("quotes") and that send to @Channel("quotes"), here.
        emitter.send(message);
        return Response.status(Response.Status.CREATED)
                .entity(message)
                .build();
    }

    @GET
    @Path("stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<Quote> stream() {
        return quotes;
    }

}
