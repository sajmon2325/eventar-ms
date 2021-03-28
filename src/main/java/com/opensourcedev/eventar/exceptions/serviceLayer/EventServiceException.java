package com.opensourcedev.eventar.exceptions.serviceLayer;

import java.sql.Timestamp;
import java.util.Map;

public class EventServiceException extends RuntimeException {

    Timestamp timestamp;
    Map<String, String> details;


    public EventServiceException(String message, Throwable cause, Timestamp timestamp, Map<String, String> details) {
        super(message, cause);
        this.timestamp = timestamp;
        this.details = details;
    }

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

    public Map<String, String> getDetails() {
        return details;
    }

    public void setDetails(Map<String, String> details) {
        this.details = details;
    }
}
