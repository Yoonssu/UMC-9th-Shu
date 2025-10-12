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
public class PreferredFoodTypeId implements Serializable {
    @Column(name = "food_key", length = 255)  // 예약어 회피
    private String key;

    private Long userId;
    private Long foodTypeId;
}
