package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.ReviewPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, String> {

    //리뷰 ID로 리뷰 사진 조회
    @Query("select rp from ReviewPhoto rp where rp.review.id = :reviewId order by rp.createdAt desc")
    List<ReviewPhoto> findPhotosByReviewId(@Param("reviewId") Long reviewId);

    //유저별 리뷰 사진 조회
    @Query("select rp from ReviewPhoto rp where rp.userId = :userId order by rp.createdAt desc")
    List<ReviewPhoto> findPhotosByUserId(@Param("userId") Long userId);
}
