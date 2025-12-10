package com.example.open_api_project.module.place.controller;

import com.example.open_api_project.common.response.ApiResponses;
import com.example.open_api_project.module.auth.security.UserDetailsImpl;
import com.example.open_api_project.module.place.dto.PlaceDto;
import com.example.open_api_project.module.place.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    // 목록 조회
    @GetMapping
    public ResponseEntity<?> getMyPlaces(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        List<PlaceDto> list = placeService.getMyPlaces(userDetails.getMember().getId());
        return ApiResponses.ok(list);
    }

    // 저장
    @PostMapping
    public ResponseEntity<?> savePlace(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                       @RequestBody PlaceDto placeDto) {
        placeDto.setMemberId(userDetails.getMember().getId());
        placeService.addPlace(placeDto);

        return ApiResponses.ok();
    }
}