package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTicketRepository extends JpaRepository<EventTicket, String> {
}
