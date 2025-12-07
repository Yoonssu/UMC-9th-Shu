package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.enums.MemberStatus;
import com.example.umc9th.global.auth.enums.Role;

import java.time.LocalDateTime;

public class MemberConverter {

    // 회원가입 응답 DTO 변환
    public static MemberResDTO.JoinResDTO toJoinResDTO(Member member) {
        return new MemberResDTO.JoinResDTO(
                member.getId(),
                member.getName(),
                member.getGender(),
                member.getStatus(),
                member.getCreatedAt()
        );
    }

    // 로그인 응답 DTO 변환
    public static MemberResDTO.LoginDTO toLoginDTO(Member member, String accessToken) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .accessToken(accessToken)
                .build();
    }

    // 회원가입 요청 DTO → Member 엔티티 변환
    public static Member toMember(MemberReqDTO.JoinReqDTO dto, String encodedPassword, Role role) {

        LocalDateTime now = LocalDateTime.now(); // 가입/수정 시점

        return Member.builder()
                .name(dto.name())
                .gender(dto.gender())
                .birthDate(dto.birthDate())
                .address(dto.address())
                .email(dto.email())
                .password(encodedPassword)       // 인코딩된 비밀번호
                .role(role)                      // 보통 ROLE_USER
                .phoneNumber(dto.phoneNumber())
                .createdAt(now)
                .updatedAt(now)
                .status(MemberStatus.ACTIVE)     // 기본 값
                // preferCategory는 PreferredFoodType으로 별도 관리
                .build();
    }
}
