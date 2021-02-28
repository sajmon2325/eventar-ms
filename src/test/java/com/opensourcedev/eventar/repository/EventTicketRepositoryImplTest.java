package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.model.EventTicket;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EventTicketRepositoryImplTest {

    @InjectMocks
    EventTicketRepositoryImpl eventTicketRepositoryImpl;

    @Mock
    EventTicketRepository eventTicketRepository;

    List<EventTicket> tickets;
    EventTicket eventTicket;
    Event testEvent;


    @BeforeEach
    void setUp() {

        System.out.println("Calling the setUp() method....");

        tickets = new ArrayList<>();

        eventTicket = new EventTicket.EventTicketBuilder().ticketName("Hackaton Ticket")
                .eventName("Hackaton")
                .eventTicketId("EventTicketId")
                .name("Simon")
                .surname("Pavlik")
                .age(18)
                .ticketPrice(BigDecimal.valueOf(20))
                .build();

        testEvent = new Event.EventBuilder().createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .updatedAt(Timestamp.valueOf(LocalDateTime.now()))
                .eventName("Hackaton")
                .eventId("SomeId")
                .location("Hroncova 20/19")
                .time(LocalDateTime.of(2020,2,27,20,3))
                .eventCapacity(35)
                .eventOccupation(30)
                .tickets(tickets)
                .build();


        System.out.println("Test objects created.... \n");

    }

    @AfterEach
    void tearDown() {
        tickets = null;
        eventTicket = null;
        testEvent = null;
        System.out.println("Test objects discarded.... \n");
    }

    @Test
    void save() {

        when(eventTicketRepository.save(eventTicket)).thenReturn(eventTicket);

        EventTicket testTicket = eventTicketRepository.save(eventTicket);

        System.out.println("Starting test assertions for EvenetTicket save() method....");

        assertAll(() ->{
            assertNotNull(eventTicket);
            assertEquals(eventTicket, testTicket);
            verify(eventTicketRepository, times(1)).save(eventTicket);
        });

        System.out.println("Testing of EvenetTicket save() method finished \n");

    }

    @Test
    void findById() {

        when(eventTicketRepository.findById(anyString())).thenReturn(Optional.of(eventTicket));

        System.out.println("Starting test assertions for EventTicket findById() method....");

        Optional<EventTicket> result = eventTicketRepository.findById("EventTicketId");

        assertAll(() ->{
            assertNotNull(eventTicket);
            assertTrue(result.isPresent());
            assertEquals(result, Optional.of(eventTicket));
            verify(eventTicketRepository, times(1)).findById("EventTicketId");
        });

        System.out.println("Testing of EventTicket findById() method finished \n");

    }

    @Test
    void existsById() {

        when(eventTicketRepository.existsById(anyString())).thenReturn(true);

        System.out.println("Starting test assertions for EventTicket existsById() method....");

        var result = eventTicketRepository.existsById("EventTicketId");

        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result);
            assertEquals(eventTicketRepository.existsById("EventTicketId"), result);
            verify(eventTicketRepository, times(2)).existsById("EventTicketId");
        });

        System.out.println("Testing of EventTicekt existsById() method finished \n");

    }

    @Test
    void findAll() {

        when(eventTicketRepository.findAll()).thenReturn(List.of(eventTicket));

        System.out.println("Starting test assertions for EventTicket findAll() method....");

        var testEventTicektList = eventTicketRepository.findAll();

        assertAll(() -> {
            assertNotNull(eventTicket);
            assertEquals(testEventTicektList, eventTicketRepository.findAll());
            verify(eventTicketRepository, times(2)).findAll();
            assertTrue(testEventTicektList.contains(eventTicket));
        });

        System.out.println("Testing of EventTicket findAll() method finished \n");

    }

    @Test
    void count() {

        long testValue = 25L;

        when(eventTicketRepository.count()).thenReturn(testValue);

        System.out.println("Starting test assertions for EventTicket count() method....");

        var count = eventTicketRepository.count();

        assertAll(() -> {
            assertNotNull(count);
            assertEquals(count, eventTicketRepository.count());
            verify(eventTicketRepository, times(2)).count();
        });

        System.out.println("Testing of EventTicekt count() method finished \n");

    }

    @Test
    void findTicketsByHoldersName() {

        when(eventTicketRepository.findTicketsByticketHolderName(anyString())).thenReturn(List.of(eventTicket));

        System.out.println("Starting test assertions for EventTicket findTicketsByHoldersName() method....");

        String holderName = "";
        List<EventTicket> eventTickets = new ArrayList<>(eventTicketRepository.findTicketsByticketHolderName("Simon"));

        for (EventTicket e : eventTickets){
            holderName = e.getName();
            System.out.println("Holder's name: " + holderName + "\n");
            assertEquals(holderName, eventTicket.getName());
        }

        assertAll(() ->{
            assertNotNull(eventTicketRepository.findTicketsByticketHolderName(eventTicket.getName()));
            assertEquals(eventTickets.size(), eventTicketRepository.findTicketsByticketHolderName(eventTicket.getName()).size());
            verify(eventTicketRepository, times(3)).findTicketsByticketHolderName(anyString());
        });

        System.out.println("Testing of EventTicket findTicketsByHoldersName() method finished \n");

    }

    @Test
    void findTicketsByHoldersSurname() {

        when(eventTicketRepository.findTicketsByHolderSurname(anyString())).thenReturn(List.of(eventTicket));

        System.out.println("Starting test assertions for EventTicket findTicketsByHoldersSurname() method....");

        String holderSurname = "";
        List<EventTicket> eventTickets = new ArrayList<>(eventTicketRepository.findTicketsByHolderSurname("Pavlik"));

        for (EventTicket e : eventTickets){
            holderSurname = e.getName();
            System.out.println("Holder's Surname: " + holderSurname + "\n");
            assertEquals(holderSurname, eventTicket.getName());
        }

        assertAll(() ->{
            assertNotNull(eventTicketRepository.findTicketsByHolderSurname(eventTicket.getSurname()));
            assertEquals(eventTickets.size(), eventTicketRepository.findTicketsByHolderSurname(eventTicket.getSurname()).size());
            verify(eventTicketRepository, times(3)).findTicketsByHolderSurname(anyString());
        });

        System.out.println("Testing of EventTicket findTicketsByHoldersSurname() method finished \n");

    }

    @Test
    void findTicketsByPrice() {

        when(eventTicketRepository.findTicketsByTicketPrice(new BigDecimal(20))).thenReturn(List.of(eventTicket));

        System.out.println("Starting test assertions for EventTicket findTicketsByPrice() method....");

        BigDecimal price;
        List<EventTicket> ticketsByPrice = new ArrayList<>(eventTicketRepository.findTicketsByTicketPrice(new BigDecimal(20)));

        for (EventTicket e : ticketsByPrice){
            price = e.getTicketPrice();
            System.out.println("Ticket Price: " + price + "\n");
            assertEquals(price, eventTicket.getTicketPrice());
        }

        assertAll(() -> {
            assertNotNull(eventTicketRepository.findTicketsByTicketPrice(eventTicket.getTicketPrice()));
            assertEquals(ticketsByPrice.size(), eventTicketRepository.findTicketsByTicketPrice(eventTicket.getTicketPrice()).size());
            verify(eventTicketRepository, times(3)).findTicketsByTicketPrice(eventTicket.getTicketPrice());
        });

        System.out.println("Testing of EventTicket findTicketsByPrice() method finished \n");
    }


}