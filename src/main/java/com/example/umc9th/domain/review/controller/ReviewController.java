package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/me")
    public ResponseEntity<List<Review>> getMyReviews(
            @RequestParam Long memberId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer rating
    ) {
        List<Review> reviews = reviewService.getMyFilteredReviews(memberId, storeName, rating);
        return ResponseEntity.ok(reviews);
    }
}
