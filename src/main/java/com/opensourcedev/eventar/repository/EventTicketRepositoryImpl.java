package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EventTicketRepositoryImpl implements CrudOperations<EventTicket, String> {

    @Autowired
    private EventTicketRepository eventTicketRepository;


    public EventTicketRepositoryImpl() {}




    @Override
    public EventTicket save(EventTicket eventTicket) {
        if (eventTicket != null){
            eventTicketRepository.save(eventTicket);
            return eventTicket;
        }else {
            // Todo: add log that eventTicket could not be saved
            return new EventTicket();
        }
    }

    @Override
    public Optional<EventTicket> findById(String id) {
        return eventTicketRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return eventTicketRepository.findById(id).isPresent();
    }

    @Override
    public Iterable<EventTicket> findAll() {
        Set<EventTicket> eventTickets = new HashSet<>();
        eventTickets.addAll(eventTicketRepository.findAll());
        return eventTickets;
    }

    @Override
    public long count() {
        return eventTicketRepository.findAll().size();
    }

    @Override
    public void deleteById(String id) {
        if (id != null && (eventTicketRepository.findById(id).isPresent())){
            eventTicketRepository.deleteById(id);
        }
        //Todo return a log if eventTicket could not be deleted

    }

    @Override
    public void deleteAll() {
        eventTicketRepository.deleteAll();
    }
}
