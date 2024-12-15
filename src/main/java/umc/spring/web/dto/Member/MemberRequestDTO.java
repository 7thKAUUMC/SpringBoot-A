package umc.spring.web.dto.Member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.Enums.Role;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotBlank
        String password;
        @NotBlank
        @Email
        String email;
        @Size(min = 5, max = 12)
        String address;
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}