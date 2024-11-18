package umc.spring.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class RegisterDto {
        @NotNull
        String name;
        @NotNull
        String address;
    }
}