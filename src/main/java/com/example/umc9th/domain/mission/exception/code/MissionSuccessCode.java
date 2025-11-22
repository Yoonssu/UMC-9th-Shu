package com.example.umc9th.domain.mission.exception.code;

import com.example.umc9th.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    FOUND(HttpStatus.OK,
            "MISSION200_1",
            "성공적으로 미션을 조회했습니다."),

    CREATED(HttpStatus.OK,
            "MISSION200_1",
            "성공적으로 미션을 등록하였습니다."),
    CHALLENGE_STARTED(HttpStatus.CREATED,
            "MISSION201_2",
            "성공적으로 미션 도전을 시작했습니다.");
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}
