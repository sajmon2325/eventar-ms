package com.opensourcedev.eventar.exceptions.webLayer;

import java.sql.Timestamp;

public class EventTicketNotFoundException extends RuntimeException {

    private Timestamp timestamp;

    public EventTicketNotFoundException(String message, Throwable cause, Timestamp timestamp) {
        super(message, cause);
        this.timestamp = timestamp;
    }

    public EventTicketNotFoundException(String message, Timestamp timestamp) {
        super(message);
        this.timestamp = timestamp;
    }






    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
