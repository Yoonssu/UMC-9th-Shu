package com.example.umc9th.domain.mission.service.query;

import com.example.umc9th.domain.mission.converter.UserMissionConverter;
import com.example.umc9th.domain.mission.dto.UserMissionResDTO;
import com.example.umc9th.domain.mission.entity.UserMission;
import com.example.umc9th.domain.mission.entity.UserMission.Status;
import com.example.umc9th.domain.mission.enums.MissionStatus;
import com.example.umc9th.domain.mission.repository.UserMissionRepository;
import com.example.umc9th.domain.mission.service.query.UserMissionQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMissionQueryServiceImpl implements UserMissionQueryService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMissionResDTO.MyMissionPageDTO findInProgressMissions(Long memberId, int page) {

        // 1-based(page 파라미터) → 0-based(PageRequest)
        int zeroBasedPage = (page <= 0) ? 0 : page - 1;

        PageRequest pageRequest = PageRequest.of(
                zeroBasedPage,
                10,
                Sort.by(Sort.Direction.DESC, "mission.id")
        );

        //  여기서 중요한 건 "UserMission.Status.IN_PROGRESS" 를 쓰는 것!
        Page<UserMission> result =
                userMissionRepository.findByMemberIdAndStatus(
                        memberId,
                        UserMission.Status.IN_PROGRESS,
                        pageRequest
                );

        return UserMissionConverter.toMyMissionPageDTO(result);
    }

}