package com.example.umc9th.domain.member.converter;

import com.example.umc9th.domain.member.enums.MemberStatus;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;

import java.time.LocalDateTime;

public class MemberConverter {

    // db에 저장된 member 엔티티를 클라이언트에게 돌려줄 응답 dto로 변환
    public static MemberResDTO.JoinResDTO toJoinResDTO(Member member) {
        return new MemberResDTO.JoinResDTO(
                member.getId(),
                member.getName(),
                member.getGender(),
                member.getStatus(),
                member.getCreatedAt()
        );
    }

    // 클라이언트에서 들어온 json을 joindto -> member 엔티티로 변환해서 db에 저장 가능하도록 함
    public static Member toMember(MemberReqDTO.JoinReqDTO dto) {

        LocalDateTime now = LocalDateTime.now(); //가입 시점이나, 업데이트 시점에 넣어줌

        return Member.builder()
                .name(dto.name())
                .gender(dto.gender())
                .birthDate(dto.birthDate())
                .address(dto.address())
                .email(dto.email())
                .phoneNumber(dto.phoneNumber())
                .createdAt(now)
                .updatedAt(now)
                // preferCategory 매핑은 JPA 매핑 설계 끝나고 추가하는 게 안전
                .build();
    }
}
