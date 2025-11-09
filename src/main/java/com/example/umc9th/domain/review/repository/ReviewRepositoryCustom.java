package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;

import java.util.List;


//왜 있냐? - 네이밍 기반 쿼리로 필터링 방식 구현 불가하기 때문
//ReviewRepository가 해당 인터페이스를 상속
//무엇을 할지만 정의하는 인터페이스 선언부
public interface ReviewRepositoryCustom {

    List<Review> findMyReviews(Long memberId, String storeName, Integer rating);
}
