package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.dto.UserMissionResDTO;

public interface UserMissionQueryService {

    UserMissionResDTO.MyMissionPageDTO findInProgressMissions(Long memberId, int page);
}