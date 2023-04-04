package academy.jairo.quarkus.kafka.consumer.quote;

import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Random;

@ApplicationScoped
public class QuoteProcessor {

    @Inject
    Logger log;

    private final Random random = new Random();

    @Incoming("quote-topic")
    @Outgoing("quotes")
    @Blocking
    public Quote process(String quoteRequest)  {
        log.infof("Receiving from kafka quote-topic > %s", quoteRequest);
        return new Quote(quoteRequest, random.nextInt(100));
    }

}
