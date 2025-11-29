package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    //회원별 리뷰 목록 (최신순)
    @Query("select r from Review r where r.member = :member order by r.createdAt desc")
    List<Review> findReviewsByMember(@Param("member") Member member);

    //특정 미션의 리뷰 (페이징 포함)
    @Query(value = "select r from Review r where r.mission = :mission order by r.createdAt desc",
            countQuery = "select count(r) from Review r where r.mission = :mission")
    Page<Review> findReviewsByMission(@Param("mission") Mission mission, Pageable pageable);

    //평균 평점
    @Query("select coalesce(avg(r.rating), 0) from Review r where r.mission = :mission")
    Double findAverageRatingByMission(@Param("mission") Mission mission);

    @Query(value = "select r from Review r where r.mission.store = :store order by r.createdAt desc",
            countQuery = "select count(r) from Review r where r.mission.store = :store")
    Page<Review> findAllByStore(@Param("store") Store store, Pageable pageable);

    Page<Review> findByMemberId(Long memberId, Pageable pageable);

}
