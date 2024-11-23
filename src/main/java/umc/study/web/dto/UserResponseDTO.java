package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {

    @Getter
    @Builder
    public static class JoinResultDTO {
        private Long userId;        // User 엔티티의 id
        private LocalDateTime createdAt;  // 현재 시간
        private String nickname;   // 닉네임 반환
        private String email;      // 이메일 반환
        private List<Integer> preferCategory;
    }
}
