package academy.jairo.quarkus.kafka.consumer.person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface PersonMapper {

    PersonRequestBody toPersonRequestBody(Person person);

    @Mapping(target = "id", ignore = true)
    Person toPerson(PersonRequestBody personRequestBody);

}
