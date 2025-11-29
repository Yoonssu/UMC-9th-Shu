package com.example.umc9th.domain.food.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PreferredFoodTypeId implements Serializable {

    @Column(name = "member_id")
    private Long memberId;      // Member PK (Long)

    @Column(name = "foods_type_id")
    private Long foodTypeId;    // FoodType PK (Long)
}
