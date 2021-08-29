package com.github.LeandroAlcantara1997.Person_API_REST.service;

import com.github.LeandroAlcantara1997.Person_API_REST.dto.request.PersonDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.dto.response.MessageResponseDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.entity.Person;
import com.github.LeandroAlcantara1997.Person_API_REST.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = Person.builder().
                firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .birthDate(personDTO.getBirthDate(personDTO.getBirthDate()))
                .build();
        Person savedPerson = personRepository.save(personDTO);
        return MessageResponseDTO.builder().message("Created person with ID").build();
    }
}
