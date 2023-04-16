package academy.jairo.quarkus.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    PersonRequestBody toPersonRequestBody(Person person);

    @Mapping(target = "id", ignore = true)
    Person toPerson(PersonRequestBody personRequestBody);

}
