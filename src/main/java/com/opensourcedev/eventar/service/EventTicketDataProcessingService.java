package com.opensourcedev.eventar.service;

import com.opensourcedev.eventar.repository.EventTicketRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventTicketDataProcessingService {

    private EventTicketRepositoryImpl eventTicketRepository;

    @Autowired
    public EventTicketDataProcessingService(EventTicketRepositoryImpl eventTicketRepository) {
        this.eventTicketRepository = eventTicketRepository;
    }


}
