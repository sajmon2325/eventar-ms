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







    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
