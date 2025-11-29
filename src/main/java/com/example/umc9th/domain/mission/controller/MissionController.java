package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.command.MissionCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.page.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;

    // 가게에 미션 등록 API
    @PostMapping("/{storeId}/missions")
    @Operation(summary = "가게에 미션 추가", description = "특정 가게에 새로운 미션을 등록합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "404", description = "가게 없음")
    })
    public ApiResponse<MissionResDTO.CreateResDTO> createMission(
            @PathVariable("storeId") Long storeId,
            @RequestBody @Valid MissionReqDTO.CreateDTO dto
    ) {
        MissionResDTO.CreateResDTO res = missionCommandService.createMission(storeId, dto);
        return ApiResponse.onSuccess(MissionSuccessCode.CREATED, res);
    }

    // 3. 가게에 미션 추가하기 API
    @GetMapping("/{storeId}/missions")
    @Operation(summary = "특정 가게의 미션 목록", description = "storeId에 해당하는 가게의 미션을 페이지네이션(10개씩)으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 (page < 1)"),
    })
    public ApiResponse<MissionResDTO.MissionPageDTO> getStoreMissions(
            @PathVariable("storeId") Long storeId,
            @ValidPage @RequestParam("page") Integer page
    ) {
        MissionResDTO.MissionPageDTO res = missionCommandService.findMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(MissionSuccessCode.FOUND, res);
    }
}
