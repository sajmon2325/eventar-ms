package com.opensourcedev.eventar.model;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Event extends BasicInformation{

    @NotBlank
    @Size(min = 10, max = 50)
    private String eventName;

    @NotBlank
    @Size(min = 10, max = 20)
    private String location;

    @FutureOrPresent
    private LocalDateTime time;

    @Positive
    private Integer eventCapacity;

    @PositiveOrZero
    private Integer eventOccupation;


    public Event() {
    }

    public Event(String eventName, String location, LocalDateTime time, Integer eventCapacity, Integer eventOccupation) {
        this.eventName = eventName;
        this.location = location;
        this.time = time;
        this.eventCapacity = eventCapacity;
        this.eventOccupation = eventOccupation;
    }


    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
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





    public static class EventBuilder{

        private String eventName;
        private String location;
        private LocalDateTime time;
        private Integer eventCapacity;
        private Integer eventOccupation;



        public EventBuilder name(String eventName){
            this.eventName = eventName;
            return this;
        }

        public EventBuilder location(String location){
            this.location = location;
            return this;
        }

        public EventBuilder time(LocalDateTime time){
            this.time = time;
            return this;
        }

        public EventBuilder eventCapacity(Integer eventCapacity){
            this.eventCapacity = eventCapacity;
            return this;
        }

        public EventBuilder eventOccupation(Integer eventOccupation){
            this.eventOccupation = eventOccupation;
            return this;
        }

        public Event build(){
            return new Event(eventName, location, time, eventCapacity, eventOccupation);
        }


    }


}
