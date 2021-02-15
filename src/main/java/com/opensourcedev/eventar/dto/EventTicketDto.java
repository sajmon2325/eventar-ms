package com.opensourcedev.eventar.dto;

import com.opensourcedev.eventar.model.Event;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class EventTicketDto extends BasicInformationDto{

    private String ticketName;
    private String eventTicketId;
    private String eventName;
    private String name;
    private String surname;
    private Integer age;
    private BigDecimal ticketPrice;
    private Event event;


    public EventTicketDto(){}

    public EventTicketDto(Timestamp createdAt, Timestamp updatedAt, String ticketName,
                          String eventTicketId, String eventName, String name, String surname,
                          Integer age, BigDecimal ticketPrice, Event event) {
        super(createdAt, updatedAt);
        this.ticketName = ticketName;
        this.eventTicketId = eventTicketId;
        this.eventName = eventName;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ticketPrice = ticketPrice;
        this.event = event;
    }


    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getEventTicketId() {
        return eventTicketId;
    }

    public void setEventTicketId(String eventTicketId) {
        this.eventTicketId = eventTicketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }




    public static class EventTicketDtoBuilder{

        private Timestamp createdAt;
        private Timestamp updatedAt;
        private String ticketName;
        private String eventTicketId;
        private String eventName;
        private String name;
        private String surname;
        private Integer age;
        private BigDecimal ticketPrice;
        private Event event;


        public EventTicketDtoBuilder createdAt(Timestamp createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public EventTicketDtoBuilder updatedAt(Timestamp updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public EventTicketDtoBuilder ticketName(String ticketName){
            this.ticketName = ticketName;
            return this;
        }

        public EventTicketDtoBuilder eventName(String eventName){
            this.eventName = eventName;
            return this;
        }

        public EventTicketDtoBuilder eventTicketId(String eventTicketId){
            this.eventTicketId = eventTicketId;
            return this;
        }

        public EventTicketDtoBuilder name(String name){
            this.name = name;
            return this;
        }

        public EventTicketDtoBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public EventTicketDtoBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public EventTicketDtoBuilder ticketPrice(BigDecimal ticketPrice){
            this.ticketPrice = ticketPrice;
            return this;
        }

        private EventTicketDtoBuilder event(Event event){
            this.event = event;
            return this;
        }


        public EventTicketDto build(){
            return new EventTicketDto(createdAt, updatedAt, ticketName, eventName, eventTicketId,
                    name, surname, age, ticketPrice, event);
        }
    }

}
