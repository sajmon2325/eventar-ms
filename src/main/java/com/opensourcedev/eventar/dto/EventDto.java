package com.opensourcedev.eventar.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class EventDto extends BasicInformationDto{

    private String eventName;
    private String eventId;
    private String location;
    private LocalDateTime time;
    private Integer eventCapacity;
    private Integer eventOccupation;
    private List<EventTicketDto> tickets;

    public EventDto(){}

    public EventDto(Timestamp createdAt, Timestamp updatedAt,
                    String eventName, String eventId, String location,
                    LocalDateTime time, Integer eventCapacity, Integer eventOccupation, List<EventTicketDto> tickets) {
        super(createdAt, updatedAt);
        this.eventName = eventName;
        this.eventId = eventId;
        this.location = location;
        this.time = time;
        this.eventCapacity = eventCapacity;
        this.eventOccupation = eventOccupation;
        this.tickets = tickets;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getEventCapacity() {
        return eventCapacity;
    }

    public void setEventCapacity(Integer eventCapacity) {
        this.eventCapacity = eventCapacity;
    }

    public Integer getEventOccupation() {
        return eventOccupation;
    }

    public void setEventOccupation(Integer eventOccupation) {
        this.eventOccupation = eventOccupation;
    }

    public List<EventTicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<EventTicketDto> tickets) {
        this.tickets = tickets;
    }







    public static class EventDtoBuilder extends BasicInformationDto{

        private Timestamp createdAt;
        private Timestamp updatedAt;
        private String eventName;
        private String eventId;
        private String location;
        private LocalDateTime time;
        private Integer eventCapacity;
        private Integer eventOccupation;
        private List<EventTicketDto> tickets;

        public EventDtoBuilder createdAt(Timestamp createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public EventDtoBuilder updatedAt(Timestamp updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public EventDtoBuilder eventName(String eventName){
            this.eventName = eventName;
            return this;
        }

        public EventDtoBuilder eventId(String eventId){
            this.eventId = eventId;
            return this;
        }

        public EventDtoBuilder location(String location){
            this.location = location;
            return this;
        }

        public EventDtoBuilder time(LocalDateTime time){
            this.time = time;
            return this;
        }

        public EventDtoBuilder eventCapacity(Integer eventCapacity){
            this.eventCapacity = eventCapacity;
            return this;
        }

        public EventDtoBuilder eventOccupation(Integer eventOccupation){
            this.eventOccupation = eventOccupation;
            return this;
        }

        public EventDtoBuilder tickets(List<EventTicketDto> tickets){
            this.tickets  = tickets;
            return this;
        }

        public EventDto build(){
            return new EventDto(createdAt, updatedAt, eventName, eventId,
                    location, time, eventCapacity,eventOccupation, tickets);
        }

    }



}
