package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.UserMissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserMissionConverter {

    public static UserMission toEntity(Member member, Mission mission) {
        return UserMission.builder()
                .member(member)
                .mission(mission)
                .status(UserMission.Status.IN_PROGRESS)
                .progress(0)
                .completedAt(null)               // 아직 완료 안 됐으니까 null
                .endAt(LocalDate.now().plusDays(7))
                .build();
    }

    // 4. 미션 도전 시작 응답용
    public static MemberMissionResDTO.ChallengeResDTO toChallengeResDTO(UserMission userMission) {

        Mission mission = userMission.getMission();

        return new MemberMissionResDTO.ChallengeResDTO(
                userMission.getMember().getId(),
                mission.getId(),
                mission.getRestaurantName(),
                mission.getRewardPoint(),
                userMission.getStatus(),        // UserMission.Status
                userMission.getProgress(),
                userMission.getEndAt()
        );
    }

    // 3. 진행중 미션 목록
    public static UserMissionResDTO.MyMissionPageDTO toMyMissionPageDTO(Page<UserMission> page) {

        List<UserMissionResDTO.MyMissionPreviewDTO> previews = page.getContent().stream()
                .map(um -> UserMissionResDTO.MyMissionPreviewDTO.builder()
                        .missionId(um.getMission().getId())
                        .restaurantName(um.getMission().getRestaurantName())
                        .rewardPoint(um.getMission().getRewardPoint())
                        .description(um.getMission().getDescription())
                        .status(um.getStatus())
                        .progress(um.getProgress())
                        .completedAt(um.getCompletedAt())
                        .endAt(um.getEndAt())
                        .build()
                )
                .toList();

        return UserMissionResDTO.MyMissionPageDTO.builder()
                .missions(previews)
                .page(page.getNumber() + 1)      // 1-based
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }

    // 완료된 미션 상세 조회용
    public static UserMissionResDTO.MyMissionDetailDTO toMyMissionDetailDTO(UserMission um) {

        Mission mission = um.getMission();

        return UserMissionResDTO.MyMissionDetailDTO.builder()
                .memberId(um.getMember().getId())
                .missionId(mission.getId())
                .restaurantName(mission.getRestaurantName())
                .rewardPoint(mission.getRewardPoint())
                .description(mission.getDescription())
                .status(um.getStatus())
                .progress(um.getProgress())
                .completedAt(um.getCompletedAt())
                .endAt(um.getEndAt())
                .build();
    }
}
