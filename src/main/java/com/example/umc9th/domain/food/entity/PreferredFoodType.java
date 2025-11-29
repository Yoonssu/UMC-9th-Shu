package com.example.umc9th.domain.food.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.umc9th.domain.member.entity.Member;

@Entity
@Table(name = "preferredfoodtype")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PreferredFoodType {

    @EmbeddedId
    private PreferredFoodTypeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")                 // PK의 memberId와 매핑
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodTypeId")               // PK의 foodTypeId와 매핑
    @JoinColumn(name = "foods_type_id")
    private FoodType foodType;
}
