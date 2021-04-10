package com.opensourcedev.eventar.service;

import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.repository.EventRepositoryImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventDataProcessingService {

    private final EventRepositoryImpl eventRepository;

    //TODO add AOP to check connection and add logs before and after the transaction happens
    //TODO create custom exceptions and throw them when something - happens  than catch those exceptions in advice methods


    public EventDataProcessingService(EventRepositoryImpl eventRepository) {
        this.eventRepository = eventRepository;
    }



    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public Event findEventById(String id){
        return eventRepository.findById(id).orElse(new Event());
    }

    @Transactional(readOnly = true, propagation = Propagation.NEVER, isolation = Isolation.REPEATABLE_READ)
    public boolean existByEventId(String id){
        return eventRepository.existsById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public Set<Event> findAllEvents(){
        return eventRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public long countEventsInDb(){
        return eventRepository.count();
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deleteByEventId(String id){
        if ((id != null) && (!id.isBlank()) && (!id.isEmpty())){
            eventRepository.deleteById(id);
        }
        // TODO throw here a custom exception regarding empty ID
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deletAllEvents(){
        eventRepository.deleteAll();
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public Set<Event> findEventsByName(String name){
        return eventRepository.findEventByName(name);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<Event> findEventByLocation(String location){
        return eventRepository.findEventByLocation(location);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<Event> findEventsByTime(LocalDateTime dateTime){
       if (dateTime != null){
           return eventRepository.findEventByTime(dateTime);
       }else {
           return new ArrayList<>();
           //TODO handle empty or not valid date or throw exception
       }
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<Event> findEventsByOccupation(){
        return eventRepository.findEventByOccupation();
    }

    
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public Event saveEvent(Event event){
        return eventRepository.saveEntity(event);
    }

}
