package umc.studymission.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.studymission.domain.enums.MemberStatus;

public class UserRequestDTO {

    @Getter
    public static class CreateDto {
        @NotBlank
        @Size(max = 20)
        private String username;

        @NotBlank
        @Email
        @Size(max = 50)
        private String email;

        @NotBlank
        @Size(min = 8, max = 60) // 비밀번호 길이 제약
        private String password;

        @Size(max = 200)
        private String likes;

        @Size(max = 15)
        private String phoneNumber;

        private MemberStatus status = MemberStatus.ACTIVE; // 기본값: ACTIVE
    }
}
