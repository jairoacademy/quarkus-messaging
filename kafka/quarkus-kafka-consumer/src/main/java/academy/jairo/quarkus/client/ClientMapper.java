package academy.jairo.quarkus.client;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ClientMapper {

    ClientRequestBody toClientRequestBody(Client client);

    @Mapping(target = "id", ignore = true)
    Client toClient(ClientRequestBody requestBody);

}
