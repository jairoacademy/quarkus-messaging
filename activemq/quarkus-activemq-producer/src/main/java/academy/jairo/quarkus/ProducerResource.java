package academy.jairo.quarkus;

import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ProducerResource {
    @Inject
    Logger log;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        log.info("Hi!");

        String bar = "Bar!";
        log.infof("Foo %s", bar);

        return "Hello from ActiveMQ Producer";
    }

}