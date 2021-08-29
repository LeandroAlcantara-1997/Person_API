package com.github.LeandroAlcantara1997.Person_API_REST.service;

import com.github.LeandroAlcantara1997.Person_API_REST.dto.request.PersonDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.dto.response.MessageResponseDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.entity.Person;
import com.github.LeandroAlcantara1997.Person_API_REST.exception.PersonNotFoundException;
import com.github.LeandroAlcantara1997.Person_API_REST.mapper.PersonMapper;
import com.github.LeandroAlcantara1997.Person_API_REST.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with ID").build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }
}
