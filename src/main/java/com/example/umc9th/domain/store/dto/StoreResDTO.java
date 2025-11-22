package com.example.umc9th.domain.store.dto;

public class StoreResDTO {

    public record CreateResDTO(
            Long storeId,
            String name,
            String address,
            Double latitude,
            Double longitude,
            String category
    ) {}
}
