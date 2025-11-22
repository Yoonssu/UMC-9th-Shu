package com.example.umc9th.domain.member.service.command;

import com.example.umc9th.domain.food.entity.FoodType;
import com.example.umc9th.domain.food.entity.PreferredFoodType;
import com.example.umc9th.domain.food.entity.PreferredFoodTypeId;
import com.example.umc9th.domain.food.exception.FoodTypeException;
import com.example.umc9th.domain.food.exception.code.FoodTypeErrorCode;
import com.example.umc9th.domain.food.repository.FoodTypeRepository;
import com.example.umc9th.domain.food.repository.PreferredFoodTypeRepository;
import com.example.umc9th.domain.member.converter.MemberConverter;
import com.example.umc9th.domain.member.dto.MemberReqDTO;
import com.example.umc9th.domain.member.dto.MemberResDTO;
import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.member.service.command.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;
    private final PreferredFoodTypeRepository preferredFoodTypeRepository;

    // 회원가입
    @Override
    @Transactional
    public MemberResDTO.JoinResDTO signup(
            MemberReqDTO.JoinReqDTO dto
    ){
        // 사용자 생성
        Member member = MemberConverter.toMember(dto);
        // DB 적용
        Member savedMember = memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if (dto.preferCategory() != null && !dto.preferCategory().isEmpty()) {

            List<PreferredFoodType> preferredList = new ArrayList<>();

            // 선호 음식 ID별 조회
            for (Long foodTypeId : dto.preferCategory()){

                // 음식 존재 여부 검증
                FoodType foodType = foodTypeRepository.findById(foodTypeId)
                        .orElseThrow(() -> new FoodTypeException(FoodTypeErrorCode.NOT_FOUND));

                //복합키 생성
                String key = savedMember.getId() + "-" + foodType.getId();
                PreferredFoodTypeId preferredId = new PreferredFoodTypeId(
                        key,
                        savedMember.getId(),
                        foodType.getId()
                );

                //PreferredFoodType 엔티티 생성
                PreferredFoodType preferred = PreferredFoodType.builder()
                        .id(preferredId)
                        .member(savedMember)
                        .foodType(foodType)
                        .build();

                preferredList.add(preferred);
            }

            // 모든 선호 음식 추가: DB 적용
            preferredFoodTypeRepository.saveAll(preferredList);
        }


        // 응답 DTO 생성
        return MemberConverter.toJoinResDTO(savedMember);
    }
}