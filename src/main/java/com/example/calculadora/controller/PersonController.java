package com.example.calculadora.controller;

import com.example.calculadora.dto.Person;
import com.example.calculadora.service.PersonService;
import com.example.calculadora.service.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/v0/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping(
            value = "/v0/hello", consumes = "application/json", produces = "application/json")
    public String createPerson(@RequestBody Person personRequest) {
        return personService.concateName(personRequest);
    }
}
