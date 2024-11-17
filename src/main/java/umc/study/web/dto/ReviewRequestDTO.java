package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class RRegisterDto {
        @NotNull
        String title;
        @NotNull
        Integer member_id;
        @NotNull
        Integer store_id;
    }
}
