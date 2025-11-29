package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class ReviewCommandController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{missionId}/reviews")
    @Operation(summary = "미션 리뷰 작성", description = "특정 미션에 대해 리뷰를 작성합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "리뷰 작성 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "검증 실패")
    })
    public ApiResponse<ReviewResDTO.CreateResDTO> createReview(
            @PathVariable("missionId") Long missionId,
            @RequestBody @Valid ReviewReqDTO.CreateDTO dto
    ) {
        ReviewResDTO.CreateResDTO res = reviewCommandService.createReview(missionId, dto);
        return ApiResponse.onSuccess(ReviewSuccessCode.CREATED, res);
    }
}
