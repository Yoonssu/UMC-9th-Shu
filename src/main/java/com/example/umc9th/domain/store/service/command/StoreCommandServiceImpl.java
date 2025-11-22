package com.example.umc9th.domain.store.service.command;

import com.example.umc9th.domain.store.converter.StoreConverter;
import com.example.umc9th.domain.store.dto.StoreReqDTO;
import com.example.umc9th.domain.store.dto.StoreResDTO;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.store.service.command.StoreCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// StoreCommandServiceImpl.java
@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public StoreResDTO.CreateResDTO createStore(StoreReqDTO.CreateDTO dto) {
        Store store = StoreConverter.toEntity(dto);
        Store saved = storeRepository.save(store);
        return StoreConverter.toCreateResDTO(saved);
    }
}
