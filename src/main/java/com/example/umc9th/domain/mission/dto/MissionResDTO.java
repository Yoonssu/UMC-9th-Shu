package com.example.umc9th.domain.mission.dto;

import java.time.LocalDateTime;

public class MissionResDTO {

    public record CreateResDTO(
            Long missionId,
            Long storeId,
            String restaurantName,
            String rewardPoint,
            String description,
            String status,
            LocalDateTime createdAt
    ) {}
}
