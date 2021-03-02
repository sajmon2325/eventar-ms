package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.BasicInformationDto;
import com.opensourcedev.eventar.model.BasicInformation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasicInformationMapper {

    BasicInformationDto basicInformationToBasicInformationDto(final BasicInformation basicInformation);
    BasicInformation basicInformationDtoToBasicInformation(final BasicInformationDto basicInformationDto);

}
