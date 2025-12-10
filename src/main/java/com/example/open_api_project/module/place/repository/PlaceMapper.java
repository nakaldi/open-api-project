package com.example.open_api_project.module.place.repository;

import com.example.open_api_project.module.place.dto.PlaceDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {

    // 내 장소 목록 조회
    List<PlaceDto> findAllByMemberId(Long memberId);

    // 장소 저장
    void save(PlaceDto placeDto);
}