package com.opensourcedev.eventar.repository.advancedQueries;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface AdvancedDbQueries<T> {

    @Query(value = "select e from Event e where e.eventName like %:name%")
    default Set<T> findByNameLike(@Param(value = "name") String name){
        return new HashSet<>();
    }

    @Query(value = "select e from Event e where e.location like %:location%")
    default List<T> findByLocation(@Param(value = "location") String location){
        return new ArrayList<>();
    }

    @Query(value = "select e from Event e where e.time= :time")
    default List<T> findByTime(@Param(value = "time") LocalDateTime time){
      return new ArrayList<>();
    }

    @Query(value = "select e from Event e")
    default List<T> findByOccupation(Sort sort){
        return new ArrayList<>();
    }

    @Query(value = "select t from EventTicket t where t.name like %:name%")
    default List<T> findTicketsByticketHolderName(@Param(value = "name") String name){
        return new ArrayList<>();
    }

    @Query(value = "select t from EventTicket t where t.surname like %:surname%")
    default List<T> findTicketsByHolderSurname(@Param(value = "surname") String surname){
        return new ArrayList<>();
    }

    @Query(value = "select t from EventTicket t where t.ticketPrice= :price")
    default List<T> findTicketsByTicketPrice(@Param(value = "price")BigDecimal price, Sort sort){
        return new ArrayList<>();
    }


}
