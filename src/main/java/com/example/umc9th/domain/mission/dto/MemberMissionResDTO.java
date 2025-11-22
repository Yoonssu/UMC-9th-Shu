package com.example.umc9th.domain.mission.dto;

import com.example.umc9th.domain.mission.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MemberMissionResDTO {

    public record ChallengeResDTO(
            Long memberId,
            Long missionId,
            String status,
            Integer progress,
            LocalDateTime completedAt,
            LocalDate endAt
    ) {}
}
