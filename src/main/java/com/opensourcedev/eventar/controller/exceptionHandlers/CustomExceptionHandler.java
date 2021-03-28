package com.opensourcedev.eventar.controller.exceptionHandlers;

import com.opensourcedev.eventar.exceptions.webLayer.EventNotFoundException;
import com.opensourcedev.eventar.exceptions.webLayer.EventTicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

    Map<String, Object> details;

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Object> handleEventNotFoundException(EventNotFoundException eventNotFound, WebRequest request){
        details = new HashMap<>();
        details.put("message: ", eventNotFound.getMessage());
        details.put("timestamp: ", eventNotFound.getTimestamp());
        details.put("path: ", request.getContextPath());
        details.put("caused by: ", eventNotFound.getCause());

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(EventTicketNotFoundException.class)
    public ResponseEntity<Object> handleEventTicketNotFoundException(EventTicketNotFoundException ticketNotFoundException,
                                                                     WebRequest request){

        details.put("message: ", ticketNotFoundException.getMessage());
        details.put("timestamp: ", ticketNotFoundException.getTimestamp());
        details.put("path: ", request.getContextPath());
        details.put("caused by: ", ticketNotFoundException.getCause());

        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
