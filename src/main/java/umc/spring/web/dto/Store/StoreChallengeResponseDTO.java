package umc.spring.web.dto.Store;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StoreChallengeResponseDTO {
    private Long challengeId;  // 도전 ID
    private Long storeId;      // 가게 ID
    private Long missionId;    // 미션 ID
    private String message;    // 성공 메시지
}