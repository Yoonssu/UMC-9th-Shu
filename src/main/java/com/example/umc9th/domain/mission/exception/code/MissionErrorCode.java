package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionErrorCode implements BaseErrorCode {
    NOT_FOUND(HttpStatus.NOT_FOUND,
            "MISSION404_1",
            "해당 미션을 찾지 못했습니다."),
    INVALID_STORE_MISSION(HttpStatus.BAD_REQUEST,
            "MISSION400_1",
            "해당 가게의 미션이 아닙니다."),

    ALREADY_IN_PROGRESS(HttpStatus.BAD_REQUEST,
            "MISSION400_2",
            "이미 진행 중인 미션입니다.")
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
