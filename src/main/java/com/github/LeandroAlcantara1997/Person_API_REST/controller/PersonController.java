package com.github.LeandroAlcantara1997.Person_API_REST.controller;


import com.github.LeandroAlcantara1997.Person_API_REST.dto.request.PersonDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.dto.response.MessageResponseDTO;
import com.github.LeandroAlcantara1997.Person_API_REST.entity.Person;
import com.github.LeandroAlcantara1997.Person_API_REST.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

}
