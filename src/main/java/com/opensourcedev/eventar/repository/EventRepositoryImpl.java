package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.*;

@Repository
public class EventRepositoryImpl implements CrudOperations<Event, String> {

    @Autowired
    private EventRepository eventRepository;



    public EventRepositoryImpl() {}



    @Override
    public Event save(Event event) {
        if(event != null){
            eventRepository.save(event);
            return event;
        }else {
            // Todo: add log that event could not be saved
            return new Event();
        }
    }

    @Override
    public Optional<Event> findById(String id) {
        return eventRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return eventRepository.findById(id).isPresent();
    }

    @Override
    public Set<Event> findAll() {
        Set<Event> events = new HashSet<>();
        events.addAll(eventRepository.findAll());
        return events;
    }

    @Override
    public long count() {
        return eventRepository.findAll().size();
    }

    @Override
    public void deleteById(String id) {
        if (id != null && (eventRepository.findById(id).isPresent())){
            eventRepository.deleteById(id);
        }
        //Todo return a log if event could not be deleted

    }

    @Override
    public void deleteAll() {
        eventRepository.deleteAll();
    }



    public Set<Event> findEventByName(String name){
        return eventRepository.findByNameLike(name);
    }

    public List<Event> findEventByLocation(String location){
        return eventRepository.findByLocation(location);
    }

    public List<Event> findEventByTime(LocalDateTime time){
        return eventRepository.findByTime(time);
    }

    public List<Event> findEventByOccupation(){
        return eventRepository.findByOccupation(Sort.by(Sort.Order.asc("eventOccupation")));
    }



}
