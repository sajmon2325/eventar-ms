package com.opensourcedev.eventar.repository;

import com.opensourcedev.eventar.model.EventTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EventTicketRepository extends JpaRepository<EventTicket, String> {


    @Query(value = "select t from EventTicket t where t.name like %:name%")
    List<EventTicket> findTicketsByticketHolderName(@Param(value = "name") String name);

    @Query(value = "select t from EventTicket t where t.surname like %:surname%")
    List<EventTicket> findTicketsByHolderSurname(@Param(value = "surname") String surname);

    @Query(value = "select t from EventTicket t where t.ticketPrice= :price")
    List<EventTicket> findTicketsByTicketPrice(@Param(value = "price") BigDecimal price);
}
