package com.github.LeandroAlcantara1997.Person_API_REST.mapper;

import com.github.LeandroAlcantara1997.Person_API_REST.dto.request.PersonDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
