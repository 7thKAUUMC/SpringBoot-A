package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDTO {

    @Getter
    public static class MRegisterDTO{
        @NotNull
        String missionSpec;
        @NotNull
        Integer reward;
        @NotNull
        LocalDate deadline;
        @NotNull
        Long store_id;
        @NotNull
        List<Long> member_id;

    }
}
