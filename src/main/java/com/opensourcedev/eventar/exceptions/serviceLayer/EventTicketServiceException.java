package com.opensourcedev.eventar.exceptions.serviceLayer;

import java.sql.Timestamp;

public class EventTicketServiceException extends RuntimeException {

    Timestamp timestamp;

    public EventTicketServiceException(String message, Throwable cause, Timestamp timestamp) {
        super(message, cause);
        this.timestamp = timestamp;
    }

    public EventTicketServiceException(String message, Timestamp timestamp) {
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
