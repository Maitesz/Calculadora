package com.example.calculadora.service;

import com.example.calculadora.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    public String concateName(Person person){
        return person.getName() + " " + person.getLastName();
    }
}
