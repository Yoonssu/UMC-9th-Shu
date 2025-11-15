package com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor //생성자 생성 -> GeneralExceptionAdvice에서 감지
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

}
