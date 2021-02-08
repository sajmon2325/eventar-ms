package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EventRepositoryImpl implements CrudOperations<Event, String> {

    @Autowired
    private EventRepository eventRepository;

    public EventRepositoryImpl() {}


    @Override
    public Event save(Event event) {
        return null;
    }

    @Override
    public Optional<Event> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public Iterable<Event> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteAll() {

    }
}
