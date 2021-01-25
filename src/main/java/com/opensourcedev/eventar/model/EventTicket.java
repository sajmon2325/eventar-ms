package com.opensourcedev.eventar.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class EventTicket extends BasicInformation{

    @NotBlank
    private String ticketName;      // should be used as public ticket ID - name of event + "ticket" suffix

    @NotBlank
    private String eventName;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String surname;

    @Range(min = 6, max = 100)
    private Integer age;

    @PositiveOrZero
    private BigDecimal ticketPrice;

    public EventTicket() {
    }

    public EventTicket(String ticketName, String eventName, String name, String surname, Integer age, BigDecimal ticketPrice) {
        this.ticketName = ticketName;
        this.eventName = eventName;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ticketPrice = ticketPrice;
    }


    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
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






    public class EventTicketBuilder{
        private String ticketName;
        private String eventName;
        private String name;
        private String surname;
        private Integer age;
        private BigDecimal ticketPrice;


        public EventTicketBuilder ticketName(String ticketName){
            this.ticketName = ticketName;
            return this;
        }

        public EventTicketBuilder eventName(String eventName){
            this.eventName = eventName;
            return this;
        }

        public EventTicketBuilder name(String name){
            this.name = name;
            return this;
        }

        public EventTicketBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public EventTicketBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public EventTicketBuilder ticketPrice(BigDecimal ticketPrice){
            this.ticketPrice = ticketPrice;
            return this;
        }


        public EventTicket build(){
            return new EventTicket(ticketName, eventName, name, surname, age, ticketPrice);
        }

    }
}