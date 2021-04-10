package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.BasicInformationDto;
import com.opensourcedev.eventar.dto.EventTicketDto;
import com.opensourcedev.eventar.model.BasicInformation;
import com.opensourcedev.eventar.model.EventTicket;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-10T20:56:54+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class EventTicketMapperImpl implements EventTicketMapper {

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
    public EventTicketDto eventTicketToEventTicketDto(EventTicket eventTicket) {
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

    @Override
    public EventTicket eventTicketDtoToEvent(EventTicketDto eventTicketDto) {
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
}
