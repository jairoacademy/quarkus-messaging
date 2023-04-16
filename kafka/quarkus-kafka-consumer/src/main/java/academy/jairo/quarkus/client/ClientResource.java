package academy.jairo.quarkus.client;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/client")
public class ClientResource {

    @Inject
    ClientMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {

        List<Client> clients = Client.listAll();
        return Response.ok(clients).build();

    }

    @GET
    @Path("byRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllByRequest() {

        List<Client> listClient = Client.listAll();
        List<ClientRequestBody> clients = listClient.stream()
                .map(client -> mapper.toClientRequestBody(client))
                .collect(Collectors.toList());


        return Response.ok(clients).build();

    }

}
