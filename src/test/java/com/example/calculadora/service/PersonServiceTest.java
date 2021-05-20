package com.example.calculadora.service;

import com.example.calculadora.dto.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonServiceTest {
    @Autowired
    PersonService personService = new PersonServiceImpl();

    @Test
    public void givenPersonReturnFullName(){
        Person person = new Person("Maite","Salazar");
        String actual = personService.concateName(person);
        String expected = "Maite Salazar";

        assertEquals(expected, actual);

    }
}
