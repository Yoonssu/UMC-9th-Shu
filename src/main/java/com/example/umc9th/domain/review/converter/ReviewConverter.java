package com.example.umc9th.domain.review.converter;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

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

    //  리뷰 페이지 → 미리보기 리스트 + 페이징 DTO
    public static ReviewResDTO.ReviewPreViewListDTO toReviewPreviewListDTO(Page<Review> page) {

        // 1) 개별 리뷰들을 PreviewDTO 리스트로 변환
        List<ReviewResDTO.ReviewPreviewDTO> previews = page.getContent().stream()
                .map(review -> new ReviewResDTO.ReviewPreviewDTO(
                        review.getId(),
                        review.getRating(),
                        review.getContent(),
                        review.getCreatedAt()
                ))
                .toList();

        // 2) 리스트 + 페이징 정보 묶어서 반환
        return new ReviewResDTO.ReviewPreViewListDTO(
                previews,
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }


    public static ReviewResDTO.MyReviewPageDTO toMyReviewPageDTO(Page<Review> page) {

        List<ReviewResDTO.MyReviewPreviewDTO> previews = page.getContent().stream()
                .map(review -> ReviewResDTO.MyReviewPreviewDTO.builder()
                        .reviewId(review.getId())
                        .storeName(review.getMission().getStore().getName())  // 엔티티 구조에 맞게 수정
                        .rating(review.getRating())
                        .content(review.getContent())
                        .createdAt(review.getCreatedAt())
                        .build()
                )
                .toList();

        return ReviewResDTO.MyReviewPageDTO.builder()
                .reviews(previews)
                .page(page.getNumber() + 1)        // 다시 1-based로 반환
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .build();
    }
}
