package umc.spring.web.dto.Store;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreMissionRequestDTO {
    @Getter
    public static class AddMissionDTO{
        @NotNull
        Long storeId;
        @NotNull
        Long missionId;
    }
}