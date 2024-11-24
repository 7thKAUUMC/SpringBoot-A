package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;

@Getter
@Builder
public class MissionChallengeResponse {
    private Long challengeId;
    private Long missionId;
    private Long userId;
    private MissionStatus status;
    private LocalDateTime startedAt;
}
