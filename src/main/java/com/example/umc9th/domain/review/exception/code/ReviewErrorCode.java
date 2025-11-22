package com.example.umc9th.domain.review.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "REVIEW404_1",
            "해당 리뷰를 찾지 못했습니다."),
    INVALID_STORE_MISSION(HttpStatus.BAD_REQUEST,
            "REVIEW400_1",
            "해당 가게의 미션이 아니므로 리뷰를 작성할 수 없습니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
