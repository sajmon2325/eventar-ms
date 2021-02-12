package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
    public Iterable<Event> findAll() {
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



}
