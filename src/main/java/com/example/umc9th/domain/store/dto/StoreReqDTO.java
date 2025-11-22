package com.example.umc9th.domain.store.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StoreReqDTO {

    public record CreateDTO(
            @NotBlank(message = "가게 이름은 필수입니다.")
            String name,

            @NotBlank(message = "가게 주소는 필수입니다.")
            String address,

            @NotNull(message = "위도는 필수입니다.")
            Double latitude,

            @NotNull(message = "경도는 필수입니다.")
            Double longitude,

            @NotBlank(message = "카테고리는 필수입니다.")
            String category
    ) {}
}
