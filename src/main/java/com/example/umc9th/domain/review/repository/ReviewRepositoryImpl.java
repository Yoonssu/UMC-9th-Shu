package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.mission.entity.QMission;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findMyReviews(Long memberId, String storeName, Integer rating) {
        QReview review = QReview.review;
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();

        // 기본 조건: 로그인한 회원의 리뷰만
        builder.and(review.member.id.eq(memberId));

        // 가게 이름 필터링
        if (storeName != null && !storeName.isEmpty()) {
            builder.and(mission.store.name.eq(storeName));
        }

        // 별점 필터링
        if (rating != null) {
            if (rating == 5) builder.and(review.rating.eq((short) 5));
            else if (rating == 4) builder.and(review.rating.between((short) 4, (short) 4));
            else if (rating == 3) builder.and(review.rating.between((short) 3, (short) 3));
            else if (rating == 2) builder.and(review.rating.between((short) 2, (short) 2));
            else if (rating == 1) builder.and(review.rating.eq((short) 1));
        }

        return queryFactory
                .selectFrom(review)
                .join(review.mission, mission).fetchJoin()
                .join(mission.store, store).fetchJoin()
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}
