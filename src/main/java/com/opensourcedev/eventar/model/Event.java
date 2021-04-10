package com.opensourcedev.eventar.model;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "event")
@Entity
public class Event extends BasicInformation{

    @NotBlank
    @Size(min = 5, max = 50)
    @Column(name = "event_name")
    private String eventName;

    @NotBlank
    @Column(name = "event_id")
    private String eventId;

    @NotBlank
    @Size(min = 10, max = 20)
    private String location;

    @FutureOrPresent
    private LocalDateTime time;

    @Positive
    @Column(name = "event_capacity")
    private Integer eventCapacity;

    @PositiveOrZero
    @Column(name = "event_occupation")
    private Integer eventOccupation;

    @OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST)
    private List<EventTicket>  tickets;


    public Event() {
    }


    public Event(Timestamp createdAt, Timestamp updatedAt,
                 @NotBlank @Size(min = 10, max = 50) String eventName, @NotBlank String eventId,
                 @NotBlank @Size(min = 10, max = 20) String location, @FutureOrPresent LocalDateTime time,
                 @Positive Integer eventCapacity, @PositiveOrZero Integer eventOccupation, List<EventTicket> tickets) {
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

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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

    public List<EventTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<EventTicket> tickets) {
        this.tickets = tickets;
    }




    public static class EventBuilder extends BasicInformation {

        private Timestamp createdAt;
        private Timestamp updatedAt;
        private String eventName;
        private String eventId;
        private String location;
        private LocalDateTime time;
        private Integer eventCapacity;
        private Integer eventOccupation;
        private List<EventTicket> tickets;


        public EventBuilder createdAt(Timestamp createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public EventBuilder updatedAt(Timestamp updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public EventBuilder eventName(String eventName) {
            this.eventName = eventName;
            return this;
        }

        public EventBuilder eventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public EventBuilder location(String location) {
            this.location = location;
            return this;
        }

        public EventBuilder time(LocalDateTime time) {
            this.time = time;
            return this;
        }

        public EventBuilder eventCapacity(Integer eventCapacity) {
            this.eventCapacity = eventCapacity;
            return this;
        }

        public EventBuilder eventOccupation(Integer eventOccupation) {
            this.eventOccupation = eventOccupation;
            return this;
        }

        public EventBuilder tickets(List<EventTicket> tickets) {
            this.tickets = tickets;
            return this;
        }

        public Event build() {
            return new Event(createdAt, updatedAt, eventName, eventId, location, time,
                    eventCapacity, eventOccupation, tickets);
        }


    }


}
