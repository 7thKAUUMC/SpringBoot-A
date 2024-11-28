package umc.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.converter.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.MissionChallenge;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MissionChallengeRepository;
import umc.study.repository.MissionRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.MissionChallengeRequest;
import umc.study.web.dto.MissionChallengeResponse;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionChallengeRepository missionChallengeRepository;
    private final UserRepository userRepository;

    public MissionChallengeResponse challengeMission(Long missionId, MissionChallengeRequest request) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        MissionChallenge missionChallenge = MissionConverter.toMissionChallenge(mission, user);
        missionChallenge = missionChallengeRepository.save(missionChallenge);

        return MissionConverter.toMissionChallengeResponse(missionChallenge);
    }
}