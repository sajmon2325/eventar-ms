package com.opensourcedev.eventar.exceptions.serviceLayer;

import java.sql.Timestamp;

public class EventServiceException extends RuntimeException {

    Timestamp timestamp;


    public EventServiceException(String message, Throwable cause, Timestamp timestamp) {
        super(message, cause);
        this.timestamp = timestamp;
    }

    public EventServiceException(String message, Timestamp timestamp) {
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
