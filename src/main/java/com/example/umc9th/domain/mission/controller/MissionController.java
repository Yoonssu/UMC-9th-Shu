package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 3. 가게에 미션 추가하기 API
    @PostMapping("/{storeId}/missions")
    public ApiResponse<MissionResDTO.CreateResDTO> createMission(
            @PathVariable Long storeId,
            @RequestBody @Valid MissionReqDTO.CreateDTO dto
    ) {
        return ApiResponse.onSuccess(
                MissionSuccessCode.CREATED,
                missionCommandService.createMission(storeId, dto)
        );
    }
}
