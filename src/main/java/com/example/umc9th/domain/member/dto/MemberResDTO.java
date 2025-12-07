package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.MemberStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {
    public record JoinResDTO(
            Long id, //회원 생성 후 DB에 저장되므로 식별을 위한 ID 필요
            String name,
            Gender gender,
            MemberStatus status,
            LocalDateTime createdAt
    ){}

    // 로그인
    @Builder
    public record LoginDTO(
            Long memberId,
            String accessToken
    ){}
}
