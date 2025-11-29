package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    //전체 미션 목록 (최신순, 페이징)
    @Query(value = "select m from Mission m order by m.createdAt desc",
            countQuery = "select count(m) from Mission m")
    Page<Mission> findAllMissions(Pageable pageable);

    //도전 가능한 미션 조회
    @Query("""
           select m
           from Mission m
           where m.status = 'SUCCESS' and m.createdAt <= :today
           order by m.createdAt desc
           """)
    Page<Mission> findAvailableMissions(@Param("today") LocalDate today, Pageable pageable);

    //보상 포인트 기준 미션 조회
    @Query("select m from Mission m where m.rewardPoint > :rewardPoint order by m.rewardPoint desc")
    List<Mission> findByRewardPointGreaterThan(@Param("rewardPoint") String rewardPoint);

    //미션 상세 조회
    @Query("select m from Mission m where m.id = :id")
    Optional<Mission> findDetailById(@Param("id") Long id);

    Page<Mission> findByStoreId(Long storeId, Pageable pageable);

    Page<Mission> findByStore(Store store, Pageable pageable);
}
