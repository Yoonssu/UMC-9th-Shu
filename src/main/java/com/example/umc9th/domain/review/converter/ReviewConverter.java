package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static Review toEntity(ReviewReqDTO.CreateDTO dto, Member member, Mission mission) {
        return Review.builder()
                .member(member)
                .mission(mission)
                .rating(dto.rating())
                .content(dto.content())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static ReviewResDTO.CreateResDTO toCreateResDTO(Review review) {
        return new ReviewResDTO.CreateResDTO(
                review.getId(),
                review.getMember().getId(),
                review.getMission().getId(),
                review.getRating(),
                review.getContent(),
                review.getCreatedAt()
        );
    }
}
