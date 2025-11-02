package com.example.umc9th.domain.inquiry.repository;

import com.example.umc9th.domain.inquiry.entity.Inquiry;
import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

    //회원별 문의 조회 (최신순)
    @Query("select i from Inquiry i where i.member = :member order by i.id desc")
    List<Inquiry> findInquiriesByMember(@Param("member") Member member);

    //제목 키워드로 검색
    @Query("select i from Inquiry i where i.title like %:keyword% order by i.id desc")
    List<Inquiry> searchInquiriesByKeyword(@Param("keyword") String keyword);
}
