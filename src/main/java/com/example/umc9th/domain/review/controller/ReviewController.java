package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.ReviewCommandService;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewCommandService reviewCommandService;

    // 2. 가게에 리뷰 추가하기 API
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResDTO.CreateResDTO> createReview(
            @PathVariable Long storeId,
            @RequestBody @Valid ReviewReqDTO.CreateDTO dto
    ) {
        return ApiResponse.onSuccess(
                ReviewSuccessCode.CREATED,
                reviewCommandService.createReview(storeId, dto)
        );
    }
}
