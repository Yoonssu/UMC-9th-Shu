package com.example.umc9th.domain.food.repository;

import com.example.umc9th.domain.food.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

    //음식명으로 조회
    @Query("select f from FoodType f where f.name = :name")
    Optional<FoodType> findByName(@Param("name") String name);
}
