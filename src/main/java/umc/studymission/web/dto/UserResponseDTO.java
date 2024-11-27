package umc.studymission.web.dto;

import lombok.*;
import lombok.NoArgsConstructor;
import umc.studymission.domain.enums.MemberStatus;

import java.time.LocalDateTime;

public class UserResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateResultDto {
        private Long id;
        private String username;
        private String email;
        private MemberStatus status;
        private LocalDateTime createdAt;
    }
}
