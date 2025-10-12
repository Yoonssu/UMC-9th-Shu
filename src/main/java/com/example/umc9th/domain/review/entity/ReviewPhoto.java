package com.example.umc9th.domain.review.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Table(name = "reviewphotos")
public class ReviewPhoto {

    @Id
    @Column(length = 255)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviews_id", nullable = false)
    private Review review;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long missionId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String photoUrl;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
