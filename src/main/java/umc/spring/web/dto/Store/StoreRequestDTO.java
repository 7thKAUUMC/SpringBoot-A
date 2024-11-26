package umc.spring.web.dto.Store;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class RegisterDto {
        @NotNull
        String name;
        @NotNull
        String address;
        @Nullable
        List<Long> storemission;
    }
}