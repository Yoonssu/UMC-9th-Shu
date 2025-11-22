package com.example.umc9th.global.validator;

import com.example.umc9th.domain.food.exception.code.FoodTypeErrorCode;
import com.example.umc9th.domain.food.repository.FoodTypeRepository;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FoodExistValidator implements ConstraintValidator<ExistFoods, List<Long>> {

    private final FoodTypeRepository foodTypeRepository;

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        // null 이나 빈 리스트는 "검증 대상 없음"으로 true 처리하는 게 보통 패턴
        if (values == null || values.isEmpty()) {
            return true;
        }

        boolean isValid = values.stream()
                .allMatch(value -> foodTypeRepository.existsById(value));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(FoodTypeErrorCode.NOT_FOUND.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
