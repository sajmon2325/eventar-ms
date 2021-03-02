package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.EventDto;
import com.opensourcedev.eventar.model.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper extends BasicInformationMapper {

    EventDto eventToEventDto(final Event event);
    Event eventDtoToEvent(final EventDto eventDto);

}
