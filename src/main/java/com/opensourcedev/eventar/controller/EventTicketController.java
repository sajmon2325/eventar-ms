package com.opensourcedev.eventar.controller;

import com.opensourcedev.eventar.dto.EventDto;
import com.opensourcedev.eventar.dto.EventTicketDto;
import com.opensourcedev.eventar.mappers.EventTicketMapper;
import com.opensourcedev.eventar.model.EventTicket;
import com.opensourcedev.eventar.service.EventTicketDataProcessingService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping({"/ticket"})
public class EventTicketController {

    private final EventTicketMapper eventTicketMapper = Mappers.getMapper(EventTicketMapper.class);
    private final EventTicketDataProcessingService eventTicketDataProcessingService;
    private static final String BASE_URL = "http://localhost:8080/ticket/";
    private HttpHeaders responseHeader;
    List<EventTicketDto> eventTicketDtos;


    public EventTicketController(EventTicketDataProcessingService eventTicketDataProcessingService) {
        this.eventTicketDataProcessingService = eventTicketDataProcessingService;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventTicketDto> findEventTicketById(@PathVariable String id){
        EventTicketDto eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(eventTicketDataProcessingService.findEventTicketById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventTicketDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/existsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity existsById(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(eventTicketDataProcessingService.existEventTicketById(id));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventTicketDto>> findAllEventTickets(){
        Set<EventTicketDto> eventTicketDtos = new HashSet<>();
        eventTicketDataProcessingService.findAllEventTickets().forEach(e -> {
            EventTicketDto eventTicket = eventTicketMapper.eventTicketToEventTicketDto(e);
            eventTicketDtos.add(eventTicket);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventTicketDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/countAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity countAllEventTickets(){
        return ResponseEntity.ok().body(eventTicketDataProcessingService.countAllEventTicketsInDb());
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteEventTicketById(@PathVariable String id){
        eventTicketDataProcessingService.deleteByEventTicketId(id);
        responseHeader = new HttpHeaders();
        responseHeader.add("Event-Ticket-Custom-Header", "Deleted Event Ticket with id: " + id);
        return ResponseEntity.noContent().headers(responseHeader).build();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/deleteAllEventTickets")
    public ResponseEntity deleteAllEventTickets(){
        eventTicketDataProcessingService.deleteAllEventTickets();
        responseHeader = new HttpHeaders();
        responseHeader.add("Event-Ticket-Custom-Header", "All Event Tickets have been deleted from database");
        return ResponseEntity.noContent().headers(responseHeader).build();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByHolderName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventTicketDto>> findEventTicketByHolderName(@PathVariable String name){
        eventTicketDtos = new ArrayList<>();
        eventTicketDataProcessingService.findEventTicketByHoldersName(name).forEach(eventTicket ->{
            EventTicketDto eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(eventTicket);
            eventTicketDtos.add(eventTicketDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventTicketDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByHolderSurname/{surname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventTicketDto>> findEventTicketByHolderSurname(@PathVariable String surname){
        eventTicketDtos = new ArrayList<>();
        eventTicketDataProcessingService.findEventTicketByHoldersSurName(surname).forEach(eventTicket -> {
            EventTicketDto eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(eventTicket);
            eventTicketDtos.add(eventTicketDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventTicketDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByPrice/{price}")
    public ResponseEntity<List<EventTicketDto>> findEventTicketByPrice(@PathVariable BigDecimal price){
        eventTicketDtos = new ArrayList<>();
        eventTicketDataProcessingService.findEventTicketByPrice(price).forEach(eventTicket -> {
            EventTicketDto eventTicketDto = eventTicketMapper.eventTicketToEventTicketDto(eventTicket);
            eventTicketDtos.add(eventTicketDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventTicketDtos);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> persistEventTicket(@RequestBody @Validated EventTicketDto eventTicketDto, BindingResult result){
        EventTicket convertedEventTicket = eventTicketMapper.eventTicketDtoToEvent(eventTicketDto);
        EventTicket savedEventTicket = eventTicketDataProcessingService.saveEventTicket(convertedEventTicket);


        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedEventTicket.getEventTicketId()))
                .body("Event Ticket has been saved");
    }

}
