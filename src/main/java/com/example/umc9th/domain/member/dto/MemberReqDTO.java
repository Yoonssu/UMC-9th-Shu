package com.example.umc9th.domain.member.dto;

import com.example.umc9th.domain.member.enums.Gender;
import com.example.umc9th.global.annotation.ExistFoods;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDTO {
    public record JoinReqDTO(
            @NotBlank
            String name,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birthDate,
            @NotNull
            String address,
            @NotNull
            String email,
            @NotNull
            String phoneNumber,
            @ExistFoods
            List<Long> preferCategory
    ){}
}
