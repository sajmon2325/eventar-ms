package com.opensourcedev.eventar.mappers;

import com.opensourcedev.eventar.dto.BasicInformationDto;
import com.opensourcedev.eventar.model.BasicInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class BasicInformationMapperImplTest {

    BasicInformationMapperImpl basicInformationMapper;
    BasicInformation basicInformation;
    BasicInformationDto basicInformationDto;

    @BeforeEach
    void setUp(){

        System.out.println("Calling sutUp() method for BasicInformationMapperImplTest class \n");

        basicInformationMapper = new BasicInformationMapperImpl();
        basicInformation = new BasicInformation(Timestamp.valueOf("2019-07-25 21:23:33"), Timestamp.valueOf("2021-01-25 21:23:33"));
        basicInformationDto = new BasicInformationDto(Timestamp.valueOf("2019-07-25 21:23:33"), Timestamp.valueOf("2021-01-25 21:23:33"));

    }

    @AfterEach
    void tearDown(){

        System.out.println("Calling tearDown() method from BasicInformationMapperImplTest class \n");
        basicInformation = null;
        basicInformationDto = null;

    }

    @Test
    void basicInformationToBasicInformationDto() {

        System.out.println("Starting test method basicInformationToBasicInformationDto()... \n");
        assertAll(() ->{
            assertNotNull(basicInformation);
            assertNotNull(basicInformationDto);
            assertEquals(basicInformationDto.getCreatedAt(), basicInformationMapper.basicInformationToBasicInformationDto(basicInformation).getCreatedAt());
            assertEquals(basicInformationDto.getUpdatedAt(), basicInformationMapper.basicInformationToBasicInformationDto(basicInformation).getUpdatedAt());
        });

    }

    @Test
    void basicInformationDtoToBasicInformation() {

        System.out.println("Starting test method basicInformationDtoToBasicInformation()... \n");
        assertAll(() -> {
            assertNotNull(basicInformation);
            assertNotNull(basicInformationDto);
            assertEquals(basicInformation.getCreatedAt(), basicInformationMapper.basicInformationDtoToBasicInformation(basicInformationDto).getCreatedAt());
            assertEquals(basicInformation.getUpdatedAt(), basicInformationMapper.basicInformationDtoToBasicInformation(basicInformationDto).getUpdatedAt());
        });
    }

}