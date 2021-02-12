package com.opensourcedev.eventar.repository.advancedQueries;



import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AdvancedDbQueries<T> {


    Set<T> findByName();
    List<T> findByLocation();
    List<T> findByTime();
    List<T> findByOccupation();

    List<T> findTicketsByticketHolderName();
    List<T> findTicketsByHolderSurname();
    List<T> findTicketsByTicketPrice();


}
