package umc.study.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionChallengeRepository missionChallengeRepository;
    private final UserRepository userRepository;

    public MissionService(MissionRepository missionRepository,
                          MissionChallengeRepository missionChallengeRepository,
                          UserRepository userRepository) {
        this.missionRepository = missionRepository;
        this.missionChallengeRepository = missionChallengeRepository;
        this.userRepository = userRepository;
    }

    public MissionChallengeResponse challengeMission(Long missionId, MissionChallengeRequest request) {
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        MissionChallenge challenge = MissionChallenge.builder()
                .mission(mission)
                .user(user)
                .status(MissionStatus.진행중)  // ChallengeStatus.IN_PROGRESS에서 변경
                .startedAt(LocalDateTime.now())
                .build();

        challenge = missionChallengeRepository.save(challenge);

        return MissionChallengeResponse.builder()
                .challengeId(challenge.getId())
                .missionId(mission.getId())
                .userId(user.getId())
                .status(challenge.getStatus())
                .startedAt(challenge.getStartedAt())
                .build();
    }
}