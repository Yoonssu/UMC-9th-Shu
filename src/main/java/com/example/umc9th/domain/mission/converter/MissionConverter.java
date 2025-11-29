package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public class MissionConverter {

    public static Mission toEntity(MissionReqDTO.CreateDTO dto, Store store) {
        return Mission.builder()
                .store(store)
                .restaurantName(dto.restaurantName())
                .rewardPoint(dto.rewardPoint())
                .description(dto.description())
                .status(MissionStatus.SUCCESS)
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
                mission.getStatus(),
                mission.getCreatedAt()
        );
    }

    public static MissionResDTO.MissionPageDTO toMissionPageDTO(Page<Mission> page) {

        List<MissionResDTO.MissionPreviewDTO> previews = page.getContent().stream()
                .map(mission -> MissionResDTO.MissionPreviewDTO.builder()
                        .missionId(mission.getId())
                        .restaurantName(mission.getRestaurantName())
                        .rewardPoint(mission.getRewardPoint())
                        .description(mission.getDescription())
                        .status(mission.getStatus())
                        .createdAt(mission.getCreatedAt())
                        .build()
                )
                .toList();

        return MissionResDTO.MissionPageDTO.builder()
                .missions(previews)
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }


}
