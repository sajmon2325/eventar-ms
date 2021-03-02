package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.EventTicketDto;
import com.opensourcedev.eventar.model.EventTicket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventTicketMapper extends BasicInformationMapper{

    EventTicketDto eventTicketToEventTicketDto(final EventTicket eventTicket);
    EventTicket eventTicketDtoToEvent(final EventTicketDto eventTicketDto);

}
