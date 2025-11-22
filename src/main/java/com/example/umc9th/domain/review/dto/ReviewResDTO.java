package com.example.umc9th.domain.review.dto;

import java.time.LocalDateTime;

public class ReviewResDTO {

    public record CreateResDTO(
            Long reviewId,
            Long memberId,
            Long missionId,
            Short rating,
            String content,
            LocalDateTime createdAt
    ) {}
}
