package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;

public interface MissionCommandService {
    MissionResDTO.CreateResDTO createMission(Long storeId, MissionReqDTO.CreateDTO dto);
    MemberMissionResDTO.ChallengeResDTO challengeMission(Long missionId);
}

