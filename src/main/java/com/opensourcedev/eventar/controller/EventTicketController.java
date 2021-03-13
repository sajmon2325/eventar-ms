package com.opensourcedev.eventar.controller;

import com.opensourcedev.eventar.mappers.EventTicketMapper;
import com.opensourcedev.eventar.service.EventTicketDataProcessingService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/ticket"})
public class EventTicketController {

    private final EventTicketMapper eventTicketMapper = Mappers.getMapper(EventTicketMapper.class);
    private final EventTicketDataProcessingService eventTicketDataProcessingService;
    private static final String BASE_URL = "http://localhost:8080/ticket/";


    public EventTicketController(EventTicketDataProcessingService eventTicketDataProcessingService) {
        this.eventTicketDataProcessingService = eventTicketDataProcessingService;
    }


}
