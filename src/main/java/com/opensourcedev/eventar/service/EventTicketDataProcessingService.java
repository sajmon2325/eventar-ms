package com.opensourcedev.eventar.service;

import com.opensourcedev.eventar.model.EventTicket;
import com.opensourcedev.eventar.repository.EventTicketRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventTicketDataProcessingService {

    private final EventTicketRepositoryImpl eventTicketRepository;

    //TODO add AOP to check connection and add logs before and after the transaction happens
    //TODO create custom exceptions and throw them when something - happens  than catch those exceptions in advice methods


    public EventTicketDataProcessingService(EventTicketRepositoryImpl eventTicketRepository) {
        this.eventTicketRepository = eventTicketRepository;
    }



    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public EventTicket findEventTicketById(String id){
        return eventTicketRepository.findById(id).orElse(new EventTicket());
    }

    @Transactional(readOnly = true, propagation = Propagation.NEVER, isolation = Isolation.REPEATABLE_READ)
    public boolean existEventTicketById(String id){
        return eventTicketRepository.existsById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public Set<EventTicket> findAllEventTickets(){
        return eventTicketRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public long countAllEventTicketsInDb(){
        return eventTicketRepository.count();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deleteByEventTicketId(String id){
        if ((id != null) && (!id.isBlank()) && (!id.isEmpty())){
            eventTicketRepository.deleteById(id);
        }
        // TODO throw here a custom exception regarding empty ID
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deleteAllEventTickets(){
        eventTicketRepository.deleteAll();
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByHoldersName(String name){
        return eventTicketRepository.findTicketsByHoldersName(name);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByHoldersSurName(String surname){
        return eventTicketRepository.findTicketsByHoldersSurname(surname);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByPrice(BigDecimal price){
        return eventTicketRepository.findTicketsByPrice(price);
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public EventTicket saveEventTicket(EventTicket eventTicket){
        return eventTicketRepository.save(eventTicket);
    }

}
