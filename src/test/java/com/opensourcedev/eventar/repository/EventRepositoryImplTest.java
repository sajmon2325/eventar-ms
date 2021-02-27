package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.model.EventTicket;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class EventRepositoryImplTest {

    @InjectMocks
    EventRepositoryImpl eventRepositoryImpl;

    @Mock
    EventRepository eventRepository;

    List<EventTicket> tickets;
    EventTicket eventTicket;
    Event testEvent;

    @BeforeEach
    void  setUp() {

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

        when(eventRepository.save(testEvent)).thenReturn(testEvent);

        Event resultEvent = eventRepository.save(testEvent);

        System.out.println("Starting test assertions for save() method....");

        assertAll(() -> {
            assertNotNull(testEvent);
            assertEquals(resultEvent,testEvent);
            verify(eventRepository, times(1)).save(testEvent);
        });


        System.out.println("Testing of save() method finished \n");
    }

    @Test
    void findById() {

        when(eventRepository.findById(anyString())).thenReturn(Optional.of(testEvent));

        System.out.println("Starting test assertions for findById() method....");

        Optional<Event> result = eventRepository.findById("SomeId");

        assertAll(() ->{
            assertNotNull(testEvent);
            assertTrue(result.isPresent());
            assertEquals(result, Optional.of(testEvent));
            verify(eventRepository, times(1)).findById("SomeId");
        });


        System.out.println("Testing of findById() method finished \n");

    }

    @Test
    void existsById() {

        when(eventRepository.existsById(anyString())).thenReturn(true);

        System.out.println("Starting test assertions for existsById() method....");

        var result = eventRepository.existsById("SomeId");

        assertAll(() -> {
            assertNotNull(result);
            assertTrue(result);
            assertEquals(eventRepository.existsById("SomeId"), result);
            verify(eventRepository, times(2)).existsById("SomeId");
        });


        System.out.println("Testing of existsById() method finished \n");


    }


    @Test
    void findAll() {

        when(eventRepository.findAll()).thenReturn(List.of(testEvent));

        System.out.println("Starting test assertions for findAll() method....");

        var testEventsList = eventRepository.findAll();

        assertAll(() -> {
            assertNotNull(testEventsList);
            assertEquals(testEventsList, eventRepository.findAll());
            verify(eventRepository, times(2)).findAll();
            assertTrue(testEventsList.contains(testEvent));
        });



        System.out.println("Testing of findAll() method finished \n");

    }

    @Test
    void count() {

        long testValue = 25L;

        when(eventRepository.count()).thenReturn(testValue);

        System.out.println("Starting test assertions for count() method....");

        var count = eventRepository.count();

        assertAll(() -> {
            assertNotNull(count);
            assertEquals(count, eventRepository.count());
            verify(eventRepository, times(2)).count();

        });

        System.out.println("Testing of count() method finished \n");

    }




    @Test
    void findEventByName() {

        when(eventRepository.findByNameLike(anyString())).thenReturn(Set.of(testEvent));

        System.out.println("Starting test assertions for findEventByName() method....");

        String name = "";
        Set<Event> event = new HashSet<>(eventRepository.findByNameLike("SomeId")); // contains one object of type Event with String .name() method


        for (Event e : event){
            name = e.getEventName();
            System.out.println("eventName: " + name + "\n");
            assertEquals(name, testEvent.getEventName());
        }

        assertAll(() ->{
            assertNotNull(eventRepository.findByNameLike(testEvent.getEventName()));
            assertEquals(event.size(), eventRepository.findByNameLike(testEvent.getEventName()).size());
            verify(eventRepository, times(3)).findByNameLike(anyString());
        });

        System.out.println("Testing of findEventByName() method finished \n");

    }

    @Test
    void findEventByLocation() {

        when(eventRepository.findByLocation(anyString())).thenReturn( List.of(testEvent));

        System.out.println("Starting test assertions for findEventByLocation() method....");

        String location = "";

        List<Event> events = new ArrayList<>(eventRepository.findByLocation("Hroncova 20/19"));

        for (Event e : events){
            location = e.getLocation();
            System.out.println("location: " + location + "\n");
            assertEquals(location, testEvent.getLocation());
        }

        assertAll(() -> {
            assertNotNull(eventRepository.findByLocation(testEvent.getLocation()));
            assertEquals(events.size(), eventRepository.findByLocation(testEvent.getLocation()).size());
            verify(eventRepository, times(3)).findByLocation("Hroncova 20/19");
        });

    }
    
}