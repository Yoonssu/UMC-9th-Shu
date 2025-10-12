package com.example.umc9th.domain.food.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.umc9th.domain.member.entity.User;

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
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodTypeId")
    @JoinColumn(name = "foods_type_id")
    private FoodType foodType;
}
