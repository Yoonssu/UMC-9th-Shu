package com.example.umc9th.domain.food.repository;

import com.example.umc9th.domain.food.entity.PreferredFoodType;
import com.example.umc9th.domain.food.entity.PreferredFoodTypeId;
import com.example.umc9th.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PreferredFoodTypeRepository extends JpaRepository<PreferredFoodType, PreferredFoodTypeId> {

    //회원이 선호하는 음식 목록
    @Query("""
           select p
           from PreferredFoodType p
           join fetch p.foodType
           where p.member = :member
           """)
    List<PreferredFoodType> findPreferredFoodsByMember(@Param("member") Member member);
}
