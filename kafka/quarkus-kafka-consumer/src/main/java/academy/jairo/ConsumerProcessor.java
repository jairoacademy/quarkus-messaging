package academy.jairo;

import academy.jairo.quarkus.kafka.consumer.client.Client;
import academy.jairo.quarkus.kafka.consumer.client.ClientMapper;
import academy.jairo.quarkus.kafka.consumer.client.ClientRequestBody;
import academy.jairo.quarkus.kafka.consumer.person.Person;
import academy.jairo.quarkus.kafka.consumer.person.PersonMapper;
import academy.jairo.quarkus.kafka.consumer.person.PersonRequestBody;
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

    @Inject
    PersonMapper personMapper;

    @Incoming("string-topic")
    @Blocking
    public void process(String request) throws InterruptedException {
        log.infof("Receiving from kafka string-topic > %s", request);
        Thread.sleep(200);
    }

    @Incoming("json-topic")
    @Blocking
    @Transactional
    public void processClientBody(JsonObject requestJson) throws InterruptedException {
        log.infof("Receiving from kafka json-topic > %s", requestJson);
        Thread.sleep(200);
        saveClient(clientMapper.toClient(ClientRequestBody.of(requestJson)));
    }

    @Incoming("person-topic")
    @Blocking
    @Transactional
    public void processPerson(PersonRequestBody personRequestBody) {
        log.infof("Receiving from kafka person-topic > %s", personRequestBody);
        savePerson(personMapper.toPerson(personRequestBody));
    }

    private void saveClient(Client client ) {
        client.persist();
        log.infof("Client saved with success > %s", client);
    }

    private void savePerson(Person person) {
        person.persist();
        log.infof("Person saved with success > %s", person);
    }

}
