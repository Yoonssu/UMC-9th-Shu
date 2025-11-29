package com.example.umc9th.domain.store.controller;

import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.code.StoreSuccessCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.store.service.command.StoreCommandService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;
    private final StoreRepository storeRepository;

    // 1. 특정 지역에 가게 추가하기 API
    @PostMapping
    public ApiResponse<StoreResDTO.CreateResDTO> createStore(
            @RequestBody @Valid StoreReqDTO.CreateDTO dto
    ) {
        return ApiResponse.onSuccess(
                StoreSuccessCode.CREATED,
                storeCommandService.createStore(dto)
        );
    }

    //  2. 등록된 가게 전체 조회
    @GetMapping
    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    // 3. 특정 가게 단건 조회 (storeId 확인용)
    @GetMapping("/{storeId}")
    public Store getStore(@PathVariable("storeId") Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("해당 ID의 가게가 없습니다. id=" + storeId));
    }
}
