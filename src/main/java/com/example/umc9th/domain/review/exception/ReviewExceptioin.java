package com.example.umc9th.domain.review.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class ReviewExceptioin extends GeneralException {
    public ReviewExceptioin(BaseErrorCode code){
        super(code);
    }
}
