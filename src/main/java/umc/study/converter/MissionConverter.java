package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Mission;
import umc.study.domain.MissionChallenge;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.web.dto.MissionChallengeResponse;

import java.time.LocalDateTime;

// converter/MissionConverter.java
@Component
public class MissionConverter {

    public static MissionChallenge toMissionChallenge(Mission mission, User user) {
        return MissionChallenge.builder()
                .mission(mission)
                .user(user)
                .status(MissionStatus.진행중)
                .startedAt(LocalDateTime.now())
                .build();
    }

    public static MissionChallengeResponse toMissionChallengeResponse(MissionChallenge missionChallenge) {
        return MissionChallengeResponse.builder()
                .challengeId(missionChallenge.getId())
                .missionId(missionChallenge.getMission().getId())
                .userId(missionChallenge.getUser().getId())
                .status(missionChallenge.getStatus())
                .startedAt(missionChallenge.getStartedAt())
                .build();
    }
}
