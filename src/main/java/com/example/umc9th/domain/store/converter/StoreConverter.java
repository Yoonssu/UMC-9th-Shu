// StoreConverter.java
package com.example.umc9th.domain.store.converter;

import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;

public class StoreConverter {

    //db - > 클라이언트
    public static Store toEntity(StoreReqDTO.CreateDTO dto) {
        return Store.builder()
                .name(dto.name())
                .address(dto.address())
                .latitude(dto.latitude())
                .longitude(dto.longitude())
                .category(dto.category())
                .build();
    }

    //클라이언트 -> db
    public static StoreResDTO.CreateResDTO toCreateResDTO(Store store) {
        return new StoreResDTO.CreateResDTO(
                store.getId(),
                store.getName(),
                store.getAddress(),
                store.getLatitude(),
                store.getLongitude(),
                store.getCategory()
        );
    }
}
