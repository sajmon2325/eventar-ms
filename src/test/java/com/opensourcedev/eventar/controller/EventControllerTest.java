package com.opensourcedev.eventar.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensourcedev.eventar.dto.EventDto;
import com.opensourcedev.eventar.mappers.EventMapper;
import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.model.EventTicket;
import com.opensourcedev.eventar.service.EventDataProcessingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.RequestResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = EventController.class)
class EventControllerTest {


    @MockBean
    private EventDataProcessingService eventDataProcessingService;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EventMapper eventMapper;
    private Event testEvent;
    private EventTicket testEventTicket;
    private List<EventTicket> tickets;
    EventDto eventDto;
    private String baseUrl = "http://localhost:8080/event/";






    @BeforeEach
    void setUp() {
        System.out.println("Calling the setUp() method from EventControllerTest.class ....");
        //eventMapper = Mappers.getMapper(EventMapper.class);
        tickets = new ArrayList<>();

        testEventTicket = new EventTicket.EventTicketBuilder().ticketName("Hackaton Ticket")
                .eventName("Hackaton")
                .eventTicketId("EventTicketId")
                .name("Simon")
                .surname("Pavlik")
                .age(18)
                .ticketPrice(BigDecimal.valueOf(20))
                .build();

        tickets.add(testEventTicket);

        testEvent = new Event.EventBuilder().createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .eventName("Hackaton")
                .eventId("someId")
                .location("Hroncova 20/19")
                .time(LocalDateTime.of(2020,2,27,20,3))
                .eventCapacity(35)
                .eventOccupation(30)
                .tickets(tickets)
                .build();
    }

    @AfterEach
    void tearDown() {
        eventDataProcessingService = null;
        mockMvc = null;
        eventMapper = null;
        testEventTicket = null;
        tickets = null;
        eventDto = null;
    }







    @Test
    void findEventById() throws Exception {

        System.out.println("Starting test assertions for EventController findEventById() method....");

        when(eventDataProcessingService.findEventById(anyString())).thenReturn(testEvent);
        eventDto = eventMapper.eventToEventDto(testEvent);


        this.mockMvc.perform(get(baseUrl + "/findById/someId"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.eventId").isNotEmpty());


        assertAll(() ->{
            assertNotNull(testEvent);
            verify(eventDataProcessingService, times(1)).findEventById(anyString());
            verify(eventMapper, times(1)).eventToEventDto(testEvent);
        });

    }

    @Test
    void existById() throws Exception {

        System.out.println("Starting test assertions for EventController existById() method....");

        when(eventDataProcessingService.existByEventId(anyString())).thenReturn(true);
        eventDto = eventMapper.eventToEventDto(testEvent);

        this.mockMvc.perform(get(baseUrl + "/existById/someId"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"))
                .andDo(print());

        assertAll(() ->{
            assertNotNull(testEvent);
            verify(eventDataProcessingService, times(1)).existByEventId(anyString());
            verify(eventMapper, times(1)).eventToEventDto(testEvent);
        });
    }

    @Test
    void findAllEvents() throws Exception {

        System.out.println("Starting test assertions for EventController findAllEvents() method....");

        when(eventDataProcessingService.findAllEvents()).thenReturn(Set.of(testEvent));

        this.mockMvc.perform(get(baseUrl + "/findAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                /*.andExpect(jsonPath("$.[3]").isNotEmpty())
                .andExpect(jsonPath("$.[2]").value("Hackaton"))*/
                .andDo(print());


        assertAll(() ->{
            assertNotNull(testEvent);
            verify(eventDataProcessingService, times(1)).findAllEvents();
        });
    }

    @Test
    void countEventsInDb() {
    }



    @Test
    void persistEvent() {
    }
}