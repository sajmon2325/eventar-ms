package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.BasicInformationDto;
import com.opensourcedev.eventar.model.BasicInformation;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-08T18:45:05+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.10 (JetBrains s.r.o.)"
)
@Component
public class BasicInformationMapperImpl implements BasicInformationMapper {

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
}
