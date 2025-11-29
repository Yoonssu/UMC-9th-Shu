package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.UserMissionResDTO;
import com.example.umc9th.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc9th.domain.mission.service.query.UserMissionQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.page.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class UserMissionQueryController {

    private final UserMissionQueryService userMissionQueryService;

    @GetMapping("/{memberId}/missions/in-progress")
    @Operation(summary = "내가 진행중인 미션 목록", description = "특정 회원의 진행중(IN_PROGRESS) 미션 목록을 10개씩 페이지네이션으로 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 (page < 1)")
    })
    public ApiResponse<UserMissionResDTO.MyMissionPageDTO> getMyInProgressMissions(
            @PathVariable("memberId") Long memberId,
            @ValidPage @RequestParam("page") Integer page
    ) {
        UserMissionResDTO.MyMissionPageDTO res =
                userMissionQueryService.findInProgressMissions(memberId, page);

        return ApiResponse.onSuccess(MissionSuccessCode.FOUND, res);
    }
}
