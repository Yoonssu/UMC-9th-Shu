package com.example.umc9th.domain.member.entity;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.domain.member.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.List;

@Builder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    //enum
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 255)
    private String address;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(nullable = false, length = 50)
    private String phoneNumber;

    //계정 처음 만들어진 시간
    @Column(nullable = false)
    private LocalDateTime createdAt;

    //마지막으로 정보가 수정된 시간
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Builder.Default //신규 회원가입 시, 무조건 Active로 시작
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MemberStatus status = MemberStatus.ACTIVE;

    //회원이 비활성 상태로 전환된 일시
    @Column(nullable = true) //탈퇴 시점에만 값 채우는 식으로 함
    private LocalDateTime inactiveDate;

    //선호 카테고리 선택 받고 싶을 때
    @Column(nullable = false)
    private List<Long> preferCategory;
}
