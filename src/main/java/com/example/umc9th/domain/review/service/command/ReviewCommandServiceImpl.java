package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.service.command.ReviewCommandService;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    // 🔥 StoreRepository는 이제 사용 안 하니까 삭제!

    private static final Long HARD_CODED_MEMBER_ID = 1L;

    @Override
    @Transactional
    public ReviewResDTO.CreateResDTO createReview(Long missionId, ReviewReqDTO.CreateDTO dto) {

        // 1) 작성자 조회 (지금은 하드코딩, 나중에 JWT)
        Member member = memberRepository.findById(HARD_CODED_MEMBER_ID)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 2) 미션 조회 (PathVariable로 받은 missionId 사용)
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        // 3) 리뷰 엔티티 생성
        Review review = ReviewConverter.toEntity(dto, member, mission);

        // 4) 저장
        Review saved = reviewRepository.save(review);

        // 5) 응답 DTO 반환
        return ReviewConverter.toCreateResDTO(saved);
    }
}

