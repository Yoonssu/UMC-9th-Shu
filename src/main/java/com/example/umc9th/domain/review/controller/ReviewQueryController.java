package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.page.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class ReviewQueryController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "내가 작성한 리뷰 목록 조회", description = "특정 회원이 작성한 리뷰를 페이지네이션으로 조회합니다. (1 page = 10개)")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청 (page < 1)")
    })
    public ApiResponse<ReviewResDTO.MyReviewPageDTO> getMyReviews(
            @PathVariable("memberId") Long memberId,
            @ValidPage @RequestParam(name = "page") Integer page
    ) {
        ReviewResDTO.MyReviewPageDTO res = reviewQueryService.findMyReviews(memberId, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND, res);
    }
}
