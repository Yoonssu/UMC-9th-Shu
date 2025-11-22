package com.example.umc9th.domain.mission.service.command;

import com.example.umc9th.domain.member.entity.Member;
import com.example.umc9th.domain.member.exception.MemberException;
import com.example.umc9th.domain.member.exception.code.MemberErrorCode;
import com.example.umc9th.domain.member.repository.MemberRepository;
import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.converter.UserMissionConverter;
import com.example.umc9th.domain.mission.dto.MemberMissionResDTO;
import com.example.umc9th.domain.mission.dto.MissionReqDTO;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.exception.MissionException;
import com.example.umc9th.domain.mission.exception.code.MissionErrorCode;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.exception.StoreException;
import com.example.umc9th.domain.store.exception.code.StoreErrorCode;
import com.example.umc9th.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final UserMissionRepository userMissionRepository;

    private static final Long HARD_CODED_MEMBER_ID = 1L;

    @Override
    @Transactional
    public MissionResDTO.CreateResDTO createMission(Long storeId, MissionReqDTO.CreateDTO dto) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        Mission mission = MissionConverter.toEntity(dto, store);
        Mission saved = missionRepository.save(mission);

        return MissionConverter.toCreateResDTO(saved);
    }

    // 4번 challengeMission 구현
    @Override
    @Transactional
    public MemberMissionResDTO.ChallengeResDTO challengeMission(Long missionId) {

        Member member = memberRepository.findById(HARD_CODED_MEMBER_ID)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        // 이미 도전 중인지 체크
        boolean exists = userMissionRepository.existsByMemberAndMission(member, mission);
        if (exists) {
            throw new MissionException(MissionErrorCode.ALREADY_IN_PROGRESS);
        }

        UserMission userMission = UserMissionConverter.toEntity(member, mission);
        UserMission saved = userMissionRepository.save(userMission);

        return UserMissionConverter.toChallengeResDTO(saved);
    }

}
