package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.CreateResDTO createReview(Long storeId, ReviewReqDTO.CreateDTO dto);
}
