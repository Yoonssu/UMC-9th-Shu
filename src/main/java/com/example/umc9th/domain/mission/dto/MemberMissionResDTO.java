package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberMissionResDTO {

    // 4. 미션 도전 시작 응답 DTO
    public record ChallengeResDTO(
            Long memberId,
            Long missionId,
            String restaurantName,
            String rewardPoint,
            UserMission.Status status,   // IN_PROGRESS
            Integer progress,
            LocalDate endAt
    ) {}

    // 5. 미션 완료 응답 DTO
    public record CompleteResDTO(
            Long memberId,
            Long missionId,
            String restaurantName,
            String rewardPoint,
            UserMission.Status status,   // COMPLETE
            Integer progress,
            LocalDateTime completedAt,
            LocalDate endAt
    ) {}
}
