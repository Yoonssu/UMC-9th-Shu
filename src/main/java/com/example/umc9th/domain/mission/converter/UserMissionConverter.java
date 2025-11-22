package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserMissionConverter {

    public static UserMission toEntity(Member member, Mission mission) {
        return UserMission.builder()
                .member(member)
                .mission(mission)
                .status(UserMission.Status.IN_PROGRESS)
                .progress(0)
                .completedAt(LocalDateTime.now())      // 시작 시점으로 임시 사용
                .endAt(LocalDate.now().plusDays(7))    // 마감일 7일 뒤로 예시
                .build();
    }

    public static MemberMissionResDTO.ChallengeResDTO toChallengeResDTO(UserMission userMission) {
        return new MemberMissionResDTO.ChallengeResDTO(
                userMission.getMember().getId(),
                userMission.getMission().getId(),
                userMission.getStatus().name(),
                userMission.getProgress(),
                userMission.getCompletedAt(),
                userMission.getEndAt()
        );
    }
}
