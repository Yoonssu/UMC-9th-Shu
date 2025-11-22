package com.example.umc9th.domain.food.exception;

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class FoodTypeException extends GeneralException {
    public FoodTypeException(BaseErrorCode code){ super(code); }
}
