package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.converter.UserMissionConverter;
import com.example.umc9th.domain.mission.dto.UserMissionResDTO;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.entity.UserMission.Status;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMissionResDTO.MyMissionDetailDTO completeMission(Long memberId, Long missionId) {

        UserMission userMission = userMissionRepository
                .findByMember_IdAndMission_Id(memberId, missionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 미션 정보가 존재하지 않습니다."));

        // 진행중 상태가 아니면 예외
        if (userMission.getStatus() != Status.IN_PROGRESS) {
            throw new IllegalStateException("진행중(IN_PROGRESS) 상태의 미션만 완료 처리할 수 있습니다.");
        }

        // 상태를 COMPLETE로 변경
        userMission.complete();
        userMissionRepository.save(userMission);

        return UserMissionConverter.toMyMissionDetailDTO(userMission);
    }
}
