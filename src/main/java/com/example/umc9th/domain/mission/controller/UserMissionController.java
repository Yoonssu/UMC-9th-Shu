package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class UserMissionController {

    private final MissionCommandService missionCommandService;

    // 4. 가게의 미션 도전하기 API
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MemberMissionResDTO.ChallengeResDTO> challengeMission(
            @PathVariable("missionId") Long missionId
    ) {
        return ApiResponse.onSuccess(
                MissionSuccessCode.CHALLENGE_STARTED,
                missionCommandService.challengeMission(missionId)
        );
    }

    // 5. 진행중인 미션 완료 API
    @PatchMapping("/{missionId}/complete")
    public ApiResponse<MemberMissionResDTO.CompleteResDTO> completeMission(
            @PathVariable("missionId") Long missionId
    ) {
        MemberMissionResDTO.CompleteResDTO res =
                missionCommandService.completeMission(missionId);

        return ApiResponse.onSuccess(MissionSuccessCode.COMPLETED, res);
    }
}

