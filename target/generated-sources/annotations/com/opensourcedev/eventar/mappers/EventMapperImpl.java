package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.BasicInformationDto;
import com.opensourcedev.eventar.dto.EventDto;
import com.opensourcedev.eventar.dto.EventTicketDto;
import com.opensourcedev.eventar.model.BasicInformation;
import com.opensourcedev.eventar.model.Event;
import com.opensourcedev.eventar.model.EventTicket;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-10T20:56:54+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public BasicInformationDto basicInformationToBasicInformationDto(BasicInformation basicInformation) {
        if ( basicInformation == null ) {
            return null;
        }

        BasicInformationDto basicInformationDto = new BasicInformationDto();

        basicInformationDto.setCreatedAt( basicInformation.getCreatedAt() );
        basicInformationDto.setUpdatedAt( basicInformation.getUpdatedAt() );

        return basicInformationDto;
    }

    @Override
    public BasicInformation basicInformationDtoToBasicInformation(BasicInformationDto basicInformationDto) {
        if ( basicInformationDto == null ) {
            return null;
        }

        BasicInformation basicInformation = new BasicInformation();

        basicInformation.setCreatedAt( basicInformationDto.getCreatedAt() );
        basicInformation.setUpdatedAt( basicInformationDto.getUpdatedAt() );

        return basicInformation;
    }

    @Override
    public EventDto eventToEventDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setCreatedAt( event.getCreatedAt() );
        eventDto.setUpdatedAt( event.getUpdatedAt() );
        eventDto.setEventName( event.getEventName() );
        eventDto.setEventId( event.getEventId() );
        eventDto.setLocation( event.getLocation() );
        eventDto.setTime( event.getTime() );
        eventDto.setEventCapacity( event.getEventCapacity() );
        eventDto.setEventOccupation( event.getEventOccupation() );
        eventDto.setTickets( eventTicketListToEventTicketDtoList( event.getTickets() ) );

        return eventDto;
    }

    @Override
    public Event eventDtoToEvent(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event event = new Event();

        event.setCreatedAt( eventDto.getCreatedAt() );
        event.setUpdatedAt( eventDto.getUpdatedAt() );
        event.setEventId( eventDto.getEventId() );
        event.setEventName( eventDto.getEventName() );
        event.setLocation( eventDto.getLocation() );
        event.setTime( eventDto.getTime() );
        event.setEventCapacity( eventDto.getEventCapacity() );
        event.setEventOccupation( eventDto.getEventOccupation() );
        event.setTickets( eventTicketDtoListToEventTicketList( eventDto.getTickets() ) );

        return event;
    }

    protected EventTicketDto eventTicketToEventTicketDto(EventTicket eventTicket) {
        if ( eventTicket == null ) {
            return null;
        }

        EventTicketDto eventTicketDto = new EventTicketDto();

        eventTicketDto.setCreatedAt( eventTicket.getCreatedAt() );
        eventTicketDto.setUpdatedAt( eventTicket.getUpdatedAt() );
        eventTicketDto.setTicketName( eventTicket.getTicketName() );
        eventTicketDto.setEventTicketId( eventTicket.getEventTicketId() );
        eventTicketDto.setEventName( eventTicket.getEventName() );
        eventTicketDto.setName( eventTicket.getName() );
        eventTicketDto.setSurname( eventTicket.getSurname() );
        eventTicketDto.setAge( eventTicket.getAge() );
        eventTicketDto.setTicketPrice( eventTicket.getTicketPrice() );
        eventTicketDto.setEvent( eventTicket.getEvent() );

        return eventTicketDto;
    }

    protected List<EventTicketDto> eventTicketListToEventTicketDtoList(List<EventTicket> list) {
        if ( list == null ) {
            return null;
        }

        List<EventTicketDto> list1 = new ArrayList<EventTicketDto>( list.size() );
        for ( EventTicket eventTicket : list ) {
            list1.add( eventTicketToEventTicketDto( eventTicket ) );
        }

        return list1;
    }

    protected EventTicket eventTicketDtoToEventTicket(EventTicketDto eventTicketDto) {
        if ( eventTicketDto == null ) {
            return null;
        }

        EventTicket eventTicket = new EventTicket();

        eventTicket.setCreatedAt( eventTicketDto.getCreatedAt() );
        eventTicket.setUpdatedAt( eventTicketDto.getUpdatedAt() );
        eventTicket.setTicketName( eventTicketDto.getTicketName() );
        eventTicket.setEventName( eventTicketDto.getEventName() );
        eventTicket.setEventTicketId( eventTicketDto.getEventTicketId() );
        eventTicket.setName( eventTicketDto.getName() );
        eventTicket.setSurname( eventTicketDto.getSurname() );
        eventTicket.setAge( eventTicketDto.getAge() );
        eventTicket.setTicketPrice( eventTicketDto.getTicketPrice() );
        eventTicket.setEvent( eventTicketDto.getEvent() );

        return eventTicket;
    }

    protected List<EventTicket> eventTicketDtoListToEventTicketList(List<EventTicketDto> list) {
        if ( list == null ) {
            return null;
        }

        List<EventTicket> list1 = new ArrayList<EventTicket>( list.size() );
        for ( EventTicketDto eventTicketDto : list ) {
            list1.add( eventTicketDtoToEventTicket( eventTicketDto ) );
        }

        return list1;
    }
}
