package academy.jairo.quarkus;

import academy.jairo.quarkus.client.Client;
import academy.jairo.quarkus.client.ClientMapper;
import academy.jairo.quarkus.client.ClientRequestBody;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class ConsumerProcessor {

    @Inject
    Logger log;

    @Inject
    ClientMapper clientMapper;

    @Incoming("string-channel")
    @Blocking
    public void process(String request) throws InterruptedException {
        log.infof("Receiving from activemq string-channel > %s", request);
        Thread.sleep(200);
    }

    @Incoming("json-channel")
    @Blocking
    @Transactional
    public void processClientBody(JsonObject requestBody) throws InterruptedException {
        log.infof("Receiving from activemq json-channel > %s", requestBody);
        Thread.sleep(200);
        saveClient(clientMapper.toClient(ClientRequestBody.of(requestBody)));

    }

    private void saveClient(Client client ) {
        log.infof("Client to save: %s", client);
        client.persist();
        log.infof("Client saved with success > %s", client);
    }

}
