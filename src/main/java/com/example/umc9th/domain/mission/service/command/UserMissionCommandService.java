package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.mission.dto.UserMissionResDTO;

public interface UserMissionCommandService {

    UserMissionResDTO.MyMissionDetailDTO completeMission(Long memberId, Long missionId);
}
