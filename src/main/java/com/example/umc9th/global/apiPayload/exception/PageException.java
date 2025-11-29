package com.example.umc9th.global.apiPayload.exception;

import com.example.umc9th.global.apiPayload.exception.code.PageErrorCode;
import lombok.Getter;

@Getter
public class PageException extends RuntimeException {

    private final PageErrorCode errorCode;

    public PageException(PageErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
