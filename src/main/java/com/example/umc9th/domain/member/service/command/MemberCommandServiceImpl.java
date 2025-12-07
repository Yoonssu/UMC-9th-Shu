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
import com.example.umc9th.global.auth.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    // Password Encoder
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public MemberResDTO.JoinResDTO signup(MemberReqDTO.JoinReqDTO dto) {

        // 솔트된 비밀번호 생성
        String salt = passwordEncoder.encode(dto.password());

        // 1. 회원 생성 & 저장
        Member member = MemberConverter.toMember(dto, salt, Role.ROLE_USER);
        Member savedMember = memberRepository.save(member);

        // 2. 선호 음식 있으면 처리
        if (dto.preferCategory() != null && !dto.preferCategory().isEmpty()) {

            List<PreferredFoodType> preferredList = new ArrayList<>();

            // preferCategory: List<Long> (FoodType PK 리스트)
            for (Long foodTypeId : dto.preferCategory()) {

                // 2-1. FoodType 존재 확인
                FoodType foodType = foodTypeRepository.findById(foodTypeId)
                        .orElseThrow(() -> new FoodTypeException(FoodTypeErrorCode.NOT_FOUND));

                // 2-2. 복합키 생성 (memberId + foodTypeId)
                PreferredFoodTypeId preferredId =
                        new PreferredFoodTypeId(savedMember.getId(), foodType.getId());

                // 2-3. PreferredFoodType 엔티티 생성
                PreferredFoodType preferred = PreferredFoodType.builder()
                        .id(preferredId)
                        .member(savedMember)
                        .foodType(foodType)
                        .build();

                preferredList.add(preferred);
            }

            // 3. 한 번에 저장
            preferredFoodTypeRepository.saveAll(preferredList);
        }

        // 4. 응답 DTO
        return MemberConverter.toJoinResDTO(savedMember);
    }
}
