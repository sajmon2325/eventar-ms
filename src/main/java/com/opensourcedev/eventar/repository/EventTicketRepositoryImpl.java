package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.*;

public class EventTicketRepositoryImpl implements CrudOperations<EventTicket, String> {

    private EventTicketRepository eventTicketRepository;

    public EventTicketRepositoryImpl() {
    }

    @Override
    public EventTicket saveEntity(EventTicket eventTicket) {
        if (eventTicket != null){
            eventTicketRepository.save(eventTicket);
            return eventTicket;
        }else {
            // Todo: add log that eventTicket could not be saved
            return new EventTicket();
        }
    }

    @Override
    public Optional<EventTicket> findEntityById(String id) {
        return eventTicketRepository.findById(id);
    }

    @Override
    public boolean existsEntityById(String id) {
        return eventTicketRepository.findById(id).isPresent();
    }

    @Override
    public Set<EventTicket> findAllEntities() {
        Set<EventTicket> eventTickets = new HashSet<>();
        eventTickets.addAll(eventTicketRepository.findAll());
        return eventTickets;
    }

    @Override
    public long countEntities() {
        return eventTicketRepository.findAll().size();
    }

    @Override
    public void deleteEntityById(String id) {
        if (id != null && (eventTicketRepository.findById(id).isPresent())){
            eventTicketRepository.deleteById(id);
        }
        //Todo return a log if eventTicket could not be deleted

    }

    @Override
    public void deleteAllEntities() {
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


    @Autowired
    public void setEventTicketRepositoryl(EventTicketRepository eventTicketRepositoryl) {
        this.eventTicketRepository = eventTicketRepositoryl;
    }
}
