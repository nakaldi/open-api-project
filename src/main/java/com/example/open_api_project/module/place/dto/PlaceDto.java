package com.example.open_api_project.module.place.dto;

import lombok.Data;

@Data
public class PlaceDto {
    private Long id;
    private Long memberId;
    private String placeName;
    private String description;
    private Double latitude;
    private Double longitude;
    private String createdAt;
}