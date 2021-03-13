package com.opensourcedev.eventar.controller;

import com.opensourcedev.eventar.dto.EventDto;
import com.opensourcedev.eventar.mappers.EventMapper;
import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.service.EventDataProcessingService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping({"/event"})
public class EventController {

    //TODO implement handling of dto being null and custom exception catched by AOP

    private final EventMapper eventMapper = Mappers.getMapper(EventMapper.class);
    private final EventDataProcessingService eventDataProcessingService;
    private static final String BASE_URL = "http://localhost:8080/event/";


    public EventController(EventDataProcessingService eventDataProcessingService) {
        this.eventDataProcessingService = eventDataProcessingService;
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventDto> findEventById(@PathVariable String id){
        EventDto eventDto = eventMapper.eventToEventDto(eventDataProcessingService.findEventById(id));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/existById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity existById(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(eventDataProcessingService.existByEventId(id));
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventDto>> findAllEvents(){
        Set<EventDto> eventDtos = new HashSet<>();
        eventDataProcessingService.findAllEvents().forEach( event -> {
            EventDto eventDto = eventMapper.eventToEventDto(event);
            eventDtos.add(eventDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/eventCount")
    public ResponseEntity countEventsInDb(){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(eventDataProcessingService.countEventsInDb());
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping(value = "/deleteById/{id}")
    public ResponseEntity deleteEventById(@PathVariable String id){
        eventDataProcessingService.deleteByEventId(id);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Event-Custom-Header", "Deleted event with id: " + id);
        return ResponseEntity.noContent().headers(responseHeader).build();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/deleteAll")
    public ResponseEntity deleteAllEvents(){
        eventDataProcessingService.deletAllEvents();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.add("Event-Custom-Header", "All Event have been deleted from database");
        return ResponseEntity.noContent().headers(responseHeader).build();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<EventDto>> findEventsByCommonName(@PathVariable String name){
        Set<EventDto> eventDtos = new HashSet<>();
        eventDataProcessingService.findEventsByName(name).forEach(event -> {
            EventDto eventDto = eventMapper.eventToEventDto(event);
            eventDtos.add(eventDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByLocation/{location}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDto>> findEventsByCommonLocation(@PathVariable String location){
        List<EventDto> eventDtos = new ArrayList<>();
        eventDataProcessingService.findEventByLocation(location).forEach(event -> {
            EventDto eventDto = eventMapper.eventToEventDto(event);
            eventDtos.add(eventDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDtos);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByTime/{time}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDto>> findEventsByCommonTime(@PathVariable LocalDateTime time){
        List<EventDto> eventDtos = new ArrayList<>();
        eventDataProcessingService.findEventsByTime(time).forEach(event -> {
            EventDto eventDto = eventMapper.eventToEventDto(event);
            eventDtos.add(eventDto);
        });

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDtos);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/findByTime", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EventDto>> findEventsByOccupation(){
        List<EventDto> eventDtos = new ArrayList<>();
        eventDataProcessingService.findEventsByOccupation().forEach(event -> {
            EventDto eventDto = eventMapper.eventToEventDto(event);
            eventDtos.add(eventDto);
        });


        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(eventDtos);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> persistEvent(@RequestBody @Validated EventDto eventDto, BindingResult result) {
        Event convertedEvent = eventMapper.eventDtoToEvent(eventDto);
        Event savedEvent = eventDataProcessingService.saveEvent(convertedEvent);


        return ResponseEntity.created(URI.create(BASE_URL + "/save/" + savedEvent.getEventId()))
                .body("Event has been saved");
    }


}
