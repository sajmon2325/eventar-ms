package com.opensourcedev.eventar.service;

import com.opensourcedev.eventar.repository.EventRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class EventDataProcessingService {

    private EventRepositoryImpl eventRepository;

    @Autowired
    public EventDataProcessingService(EventRepositoryImpl eventRepository) {
        this.eventRepository = eventRepository;
    }

    
}
