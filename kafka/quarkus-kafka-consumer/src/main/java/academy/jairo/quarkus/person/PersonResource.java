package academy.jairo.quarkus.person;

import academy.jairo.quarkus.client.Client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/person")
public class PersonResource {

    @Inject
    PersonMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<Person> listClient = Person.listAll();
        return Response.ok(listClient).build();

    }

    @GET
    @Path("byRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByRequest() {

        List<Person> list = Client.listAll();
        List<PersonRequestBody> listPerson = list.stream()
                .map(client -> mapper.toPersonRequestBody(client))
                .collect(Collectors.toList());


        return Response.ok(listPerson).build();

    }

}
