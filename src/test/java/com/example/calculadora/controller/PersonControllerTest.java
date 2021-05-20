package com.example.calculadora.controller;

import com.example.calculadora.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @Test
    public void givenAValidGetRequestToSayHelloEndPointReturnAValidResponse() throws Exception {

        when(personService.formatName(any())).thenReturn("Hello Maite!");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/v0/hello")
                .param("myName", "Maite")
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        String expected = "Hello Maite!";

        assertEquals(expected, actual);
    }

    @Test
    public void givenAValidPostRequestToCreatePersonEndPointReturnAValidResponse() throws Exception {

        when(personService.concateName(any())).thenReturn("Maite Salazar");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/v0/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Maite\",\"lastName\":\"Salazar\"}")
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();

        String actual = result.getResponse().getContentAsString();
        String expected = "Maite Salazar";

        assertEquals(expected, actual);
    }
}


