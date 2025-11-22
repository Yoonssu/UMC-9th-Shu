package com.example.umc9th.domain.mission.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MissionReqDTO {

    public record CreateDTO(
            @NotBlank(message = "식당 이름은 필수입니다.")
            String restaurantName,

            @NotBlank(message = "보상 포인트는 필수입니다.")
            String rewardPoint,  // 엔티티가 String 이라 맞춤

            @NotBlank(message = "미션 설명은 필수입니다.")
            String description
    ) {}
}
