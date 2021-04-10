package com.opensourcedev.eventar.service;

import com.opensourcedev.eventar.model.EventTicket;
import com.opensourcedev.eventar.repository.EventTicketRepositoryImpl;
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

    private final EventTicketRepositoryImpl eventTicketRepositoryImpl;

    //TODO add AOP to check connection and add logs before and after the transaction happens
    //TODO create custom exceptions and throw them when something - happens  than catch those exceptions in advice methods


    public EventTicketDataProcessingService(EventTicketRepositoryImpl eventTicketRepositoryImpl) {
        this.eventTicketRepositoryImpl = eventTicketRepositoryImpl;
    }



    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public EventTicket findEventTicketById(String id){
        return eventTicketRepositoryImpl.findById(id).orElse(new EventTicket());
    }

    @Transactional(readOnly = true, propagation = Propagation.NEVER, isolation = Isolation.REPEATABLE_READ)
    public boolean existEventTicketById(String id){
        return eventTicketRepositoryImpl.existsById(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public Set<EventTicket> findAllEventTickets(){
        return eventTicketRepositoryImpl.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, isolation = Isolation.REPEATABLE_READ)
    public long countAllEventTicketsInDb(){
        return eventTicketRepositoryImpl.count();
    }

    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deleteByEventTicketId(String id){
        if ((id != null) && (!id.isBlank()) && (!id.isEmpty())){
            eventTicketRepositoryImpl.deleteById(id);
        }
        // TODO throw here a custom exception regarding empty ID
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void deleteAllEventTickets(){
        eventTicketRepositoryImpl.deleteAll();
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByHoldersName(String name){
        return eventTicketRepositoryImpl.findTicketsByHoldersName(name);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByHoldersSurName(String surname){
        return eventTicketRepositoryImpl.findTicketsByHoldersSurname(surname);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    public List<EventTicket> findEventTicketByPrice(BigDecimal price){
        return eventTicketRepositoryImpl.findTicketsByPrice(price);
    }


    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public EventTicket saveEventTicket(EventTicket eventTicket){
        return eventTicketRepositoryImpl.saveEntity(eventTicket);
    }

}
