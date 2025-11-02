package com.example.umc9th.domain.food.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.umc9th.domain.member.entity.Member;

@Entity
@Table(name = "preferredfoodtype")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferredFoodType {

    @EmbeddedId
    private PreferredFoodTypeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodTypeId")
    @JoinColumn(name = "foods_type_id")
    private FoodType foodType;
}
