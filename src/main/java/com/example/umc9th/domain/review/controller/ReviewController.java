package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.review.service.query.ReviewQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.page.ValidPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class ReviewController implements ReviewControllerDocs {

    private final ReviewQueryService reviewQueryService;

    // 가게의 리뷰 목록 조회
    @GetMapping("/reviews")
    @Override
    public ApiResponse<ReviewResDTO.ReviewPreViewListDTO> getReviews(
            @RequestParam String storeName,
            @ValidPage @RequestParam Integer page  // ✅ 여기에도 유효성
    ) {
        ReviewResDTO.ReviewPreViewListDTO res = reviewQueryService.findReview(storeName, page);
        return ApiResponse.onSuccess(ReviewSuccessCode.FOUND, res);
    }


    @GetMapping("/reviews/search")
    public ApiResponse<?> searchReview(
            @RequestParam String filter,
            @RequestParam String type
    ) throws Exception {

        return ApiResponse.onSuccess(
                ReviewSuccessCode.FOUND,
                reviewQueryService.searchReview(filter, type)
        );
    }
}


