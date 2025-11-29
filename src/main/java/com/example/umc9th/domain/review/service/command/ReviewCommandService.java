package com.example.umc9th.domain.review.service.command;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;

public interface ReviewCommandService {
    ReviewResDTO.CreateResDTO createReview(Long missionId, ReviewReqDTO.CreateDTO dto);
}
