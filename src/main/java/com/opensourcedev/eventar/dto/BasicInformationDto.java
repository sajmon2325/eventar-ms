package com.opensourcedev.eventar.dto;

import java.sql.Timestamp;

public class BasicInformationDto {

    private Timestamp createdAt;
    private Timestamp updatedAt;

    public BasicInformationDto() {
    }

    public BasicInformationDto(Timestamp createdAt, Timestamp updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
