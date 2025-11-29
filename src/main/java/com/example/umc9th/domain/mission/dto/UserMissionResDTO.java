package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.UserMission.Status;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserMissionResDTO {

    // 내가 진행중인 미션 미리보기
    @Builder
    public record MyMissionPreviewDTO(
            Long missionId,
            String restaurantName,
            String rewardPoint,
            String description,
            Status status,
            Integer progress,
            LocalDateTime completedAt,
            LocalDate endAt
    ) {}

    // 진행중인 미션 목록 (페이지네이션)
    @Builder
    public record MyMissionPageDTO(
            List<MyMissionPreviewDTO> missions,
            int page,
            int size,
            long totalElements,
            int totalPages
    ) {}

    // 완료 처리 후 반환하는 상세 정보
    @Builder
    public record MyMissionDetailDTO(
            Long memberId,
            Long missionId,
            String restaurantName,
            String rewardPoint,
            String description,
            Status status,
            Integer progress,
            LocalDateTime completedAt,
            LocalDate endAt
    ) {}
}
