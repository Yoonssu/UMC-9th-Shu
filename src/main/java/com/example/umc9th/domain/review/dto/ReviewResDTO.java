package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReviewResDTO {

    public record CreateResDTO(
            Long reviewId,
            Long memberId,
            Long missionId,
            Short rating,
            String content,
            LocalDateTime createdAt
    ) {}

    // 1) 개별 리뷰 미리보기 DTO
    @Builder
    public record ReviewPreviewDTO(
            Long reviewId,
            Short rating,
            String content,
            LocalDateTime createdAt
    ) {}

    // 2) 리뷰 목록 + 페이징 DTO
    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreviewDTO> reviews,
            int page,
            int size,
            long totalElements,
            int totalPages
    ) {}

    @Builder
    public record MyReviewPreviewDTO(
            Long reviewId,
            String storeName,
            Short rating,
            String content,
            LocalDateTime createdAt
    ) {}

    @Builder
    public record MyReviewPageDTO(
            List<MyReviewPreviewDTO> reviews,
            int page,          // 1-based 로 보내줄 예정
            int size,
            long totalElements,
            int totalPages
    ) {}

}
