package com.example.umc9th.domain.member.repository;

import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //이름으로 회원 조회 (비활성 회원 제외)
    @Query("select m from Member m where m.name = :name and m.inactiveDate is null")
    List<Member> findActiveMembersByName(@Param("name") String name);

    //이메일로 활성 회원 조회
    @Query("select m from Member m where m.email = :email and m.status = 'ACTIVE'")
    Optional<Member> findActiveMemberByEmail(@Param("email") String email);

    // 특정 상태(status)의 회원 전체 조회
    @Query("select m from Member m where m.status = :status")
    List<Member> findByStatus(@Param("status") String status);
}
