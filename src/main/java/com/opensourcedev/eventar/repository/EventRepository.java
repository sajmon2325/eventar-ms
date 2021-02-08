package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, String> {
}
