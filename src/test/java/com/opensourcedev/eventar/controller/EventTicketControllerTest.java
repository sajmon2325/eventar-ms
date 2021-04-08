package com.opensourcedev.eventar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensourcedev.eventar.dto.EventTicketDto;
import com.opensourcedev.eventar.mappers.EventTicketMapper;
import com.opensourcedev.eventar.model.EventTicket;
import com.opensourcedev.eventar.service.EventTicketDataProcessingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EventTicketController.class)
class EventTicketControllerTest {


    @MockBean
    private EventTicketDataProcessingService eventTicketDataProcessingService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EventTicketMapper eventTicketMapper;

    private EventTicketDto eventTicketDto;
    private EventTicket testEventTicket;
    private String baseUrl = "http://localhost:8080/ticket/";
    List<EventTicket> eventTicketDtos;

    @BeforeEach
    void setUp() {

        System.out.println("Calling the setUp() method from EventTicketControllerTest.class ....");

        eventTicketDtos = new ArrayList<>();

        testEventTicket = new EventTicket.EventTicketBuilder().eventTicketId("newId")
                .ticketName("Hackaton Ticket")
                .eventName("Hackaton")
                .eventTicketId("EventTicketId")
                .name("Simon")
                .surname("Pavlik")
                .age(18)
                .ticketPrice(BigDecimal.valueOf(20))
                .build();

        eventTicketDtos.add(testEventTicket);
    }

    @AfterEach
    void tearDown() {

        System.out.println("Calling the tearDown() method from EventTicketControllerTest.class ....");

        eventTicketDataProcessingService = null;
        mockMvc = null;
        eventTicketMapper = null;
        testEventTicket = null;
        eventTicketDtos = null;
    }




    @Test
    void findEventTicketById() throws Exception {

        System.out.println("Starting test assertions for EventTicketController findEventTicketById() method....");

        when(eventTicketDataProcessingService.findEventTicketById(anyString())).thenReturn(testEventTicket);
        eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(testEventTicket);

        this.mockMvc.perform(get(baseUrl + "/findById/newId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.eventTicketId").isNotEmpty());

        assertAll(() ->{
            assertNotNull(testEventTicket);
            verify(eventTicketDataProcessingService, times(1)).findEventTicketById("newId");
            verify(eventTicketMapper, times(1)).eventTicketToEventTicketDto(testEventTicket);
        });

    }

    @Test
    void existsById() throws Exception {

        System.out.println("Starting test assertions for EventTicketController existsById() method....");

        when(eventTicketDataProcessingService.existEventTicketById(anyString())).thenReturn(true);
        eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(testEventTicket);

        this.mockMvc.perform(get(baseUrl + "/existsById/newId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("true"))
                .andDo(print());

        assertAll(() ->{
            assertNotNull(testEventTicket);
            verify(eventTicketDataProcessingService, times(1)).existEventTicketById("newId");
            verify(eventTicketMapper, times(1)).eventTicketToEventTicketDto(testEventTicket);
        });

    }

    @Test
    void findAllEventTickets() throws Exception {

        System.out.println("Starting test assertions for EventTicketController findAllEventTickets() method....");

        when(eventTicketDataProcessingService.findAllEventTickets()).thenReturn(Set.of(testEventTicket));

        this.mockMvc.perform(get(baseUrl + "/findAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("\"ticketName\":\"Hackaton Ticket\"")))
                .andDo(print());

        assertAll(() -> {
            assertNotNull(testEventTicket);
            verify(eventTicketDataProcessingService, times(1)).findAllEventTickets();
        });
    }

    @Test
    void countAllEventTickets() throws Exception {

        System.out.println("Starting test assertions for EventTicketController countAllEventTickets() method....");

        when(eventTicketDataProcessingService.countAllEventTicketsInDb()).thenReturn(12L);

        this.mockMvc.perform(get(baseUrl + "/countAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("12")))
                .andDo(print());

        assertAll(() ->{
            verify(eventTicketDataProcessingService, times(1)).countAllEventTicketsInDb();
        });

    }

    /*@Test
    void persistEventTicket() throws Exception {

        System.out.println("Starting test assertions for EventTicketController persistEventTicket() method....");

        when(eventTicketDataProcessingService.saveEventTicket(testEventTicket)).thenReturn(testEventTicket);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(testEventTicket);
        System.out.println(json);

        this.mockMvc.perform(post(baseUrl + "/save").contentType(MediaType.APPLICATION_JSON)
                    .content(json)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }*/
}