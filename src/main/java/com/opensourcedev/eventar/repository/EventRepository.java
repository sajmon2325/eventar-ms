package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.Event;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "select e from Event e where e.eventName like %:name%")
    Set<Event> findByNameLike(@Param(value = "name") String name);

    @Query(value = "select e from Event e where e.location like %:location%")
    List<Event> findByLocation(@Param(value = "location") String location);

    @Query(value = "select e from Event e where e.time= :time")
    List<Event> findByTime(@Param(value = "time") LocalDateTime time);

    @Query(value = "select e from Event e")
    List<Event> findByOccupation(Sort sort);
}
