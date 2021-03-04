package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
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
    public Set<EventTicket> findAll() {
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



    public List<EventTicket> findTicketsByHoldersName(String name){
        return eventTicketRepository.findTicketsByticketHolderName(name);
    }

    public List<EventTicket> findTicketsByHoldersSurname(String surname){
        return eventTicketRepository.findTicketsByHolderSurname(surname);
    }

    public List<EventTicket> findTicketsByPrice(BigDecimal price){
        return eventTicketRepository.findTicketsByTicketPrice(price);
    }



}
