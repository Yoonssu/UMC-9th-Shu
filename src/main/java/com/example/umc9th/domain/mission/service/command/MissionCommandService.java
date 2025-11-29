package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.CreateResDTO createMission(Long storeId, MissionReqDTO.CreateDTO dto);
    // 미션 도전 시작
    MemberMissionResDTO.ChallengeResDTO challengeMission(Long missionId);

    // 미션 완료 처리
    MemberMissionResDTO.CompleteResDTO completeMission(Long missionId);

    MissionResDTO.MissionPageDTO findMissionsByStore(Long storeId, Integer page);
}

