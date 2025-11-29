package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {

    public record CreateResDTO(
            Long missionId,
            Long storeId,
            String restaurantName,
            String rewardPoint,
            String description,
            MissionStatus status,
            LocalDateTime createdAt
    ) {}

    // 개별 미션 미리보기
    @Builder
    public record MissionPreviewDTO(
            Long missionId,
            String restaurantName,
            String rewardPoint,
            String description,
            MissionStatus status,
            LocalDateTime createdAt
    ) {}

    // 미션 목록 + 페이징 정보
    @Builder
    public record MissionPageDTO(
            List<MissionPreviewDTO> missions,
            int page,          // 프론트에 1-based로 반환
            int size,
            long totalElements,
            int totalPages
    ) {}

    // 내가 진행중인 미션 미리보기
    @Builder
    public record MyMissionPreviewDTO(
            Long missionId,
            String restaurantName,
            String rewardPoint,
            String description,
            MissionStatus status,
            Integer progress,
            LocalDateTime completedAt,
            LocalDate endAt
    ) {}


}

