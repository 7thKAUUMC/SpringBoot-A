package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MissionChallengeRequest {
    @NotNull(message = "User ID is required")
    private Long userId;
}