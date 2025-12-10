package com.example.open_api_project.module.place.service;
import com.example.open_api_project.module.place.dto.PlaceDto;
import com.example.open_api_project.module.place.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceMapper placeMapper;

    public List<PlaceDto> getMyPlaces(Long memberId) {
        return placeMapper.findAllByMemberId(memberId);
    }

    public void addPlace(PlaceDto placeDto) {
        placeMapper.save(placeDto);
    }
}