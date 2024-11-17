package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import umc.study.validation.annotation.ExistCategories;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class RegisterDto {
        @NotNull
        String name;
        @NotNull
        String address;
    }
}
