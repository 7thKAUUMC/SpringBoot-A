package umc.spring.web.dto.Store;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class StoreChallengeRequestDTO {
    @NotNull
    private Long storeId;

    @NotNull
    private Long missionId;

    @NotNull
    private Long memberId;
}