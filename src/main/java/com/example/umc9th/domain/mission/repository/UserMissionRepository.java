package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.entity.UserMissionId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserMissionRepository extends JpaRepository<UserMission, UserMissionId> {

    // 회원별 특정 상태(IN_PROGRESS, COMPLETE) 미션 조회 (페이징)
    @Query("""
           select um
           from UserMission um
           where um.member = :member
           and um.status = :status
           """)
    Page<UserMission> findUserMissionsByStatus(@Param("member") Member member,
                                               @Param("status") UserMission.Status status,
                                               Pageable pageable);

    // 완료된 미션 개수
    @Query("""
           select count(um)
           from UserMission um
           where um.member.id = :memberId
           and um.status = 'COMPLETE'
           """)
    Long countCompletedMissions(@Param("memberId") Long memberId);

    // 평균 진행률
    @Query("select avg(um.progress) from UserMission um where um.member.id = :memberId")
    Double findAverageProgress(@Param("memberId") Long memberId);

    // 특정 회원이 특정 미션을 이미 도전 중인지 여부
    boolean existsByMemberAndMission(Member member, Mission mission);
}
