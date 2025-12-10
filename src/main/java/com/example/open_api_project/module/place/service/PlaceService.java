package com.example.open_api_project.module.place.service;

import com.example.open_api_project.module.place.dto.PlaceDto;

import java.util.List;

public interface PlaceService {

    List<PlaceDto> getMyPlaces(Long memberId);

    void addPlace(PlaceDto placeDto);
}
