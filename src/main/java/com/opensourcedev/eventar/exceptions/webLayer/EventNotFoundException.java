package com.opensourcedev.eventar.exceptions.webLayer;

import java.sql.Timestamp;

public class EventNotFoundException extends RuntimeException {

    Timestamp timestamp;


    public EventNotFoundException(String message, Throwable cause, Timestamp timestamp) {
        super(message, cause);
        this.timestamp = timestamp;
    }

    public EventNotFoundException(String message, Timestamp timestamp) {
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
