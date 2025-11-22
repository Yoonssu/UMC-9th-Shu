package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;

import java.time.LocalDateTime;

public class MissionConverter {

    public static Mission toEntity(MissionReqDTO.CreateDTO dto, Store store) {
        return Mission.builder()
                .store(store)
                .restaurantName(dto.restaurantName())
                .rewardPoint(dto.rewardPoint())
                .description(dto.description())
                .status(Mission.MissionStatus.SUCCESS) // 기본값 (과제니까 임시로)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResDTO.CreateResDTO toCreateResDTO(Mission mission) {
        return new MissionResDTO.CreateResDTO(
                mission.getId(),
                mission.getStore().getId(),
                mission.getRestaurantName(),
                mission.getRewardPoint(),
                mission.getDescription(),
                mission.getStatus().name(),
                mission.getCreatedAt()
        );
    }
}
