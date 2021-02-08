package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EventTicketRepositoryImpl implements CrudOperations<EventTicket, String> {

    private EventTicketRepository eventTicketRepository;


    public EventTicketRepositoryImpl(EventTicketRepository eventTicketRepository) {
        this.eventTicketRepository = eventTicketRepository;
    }




    @Override
    public EventTicket save(EventTicket eventTicket) {
        return null;
    }

    @Override
    public Optional<EventTicket> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public Iterable<EventTicket> findAll() {
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
