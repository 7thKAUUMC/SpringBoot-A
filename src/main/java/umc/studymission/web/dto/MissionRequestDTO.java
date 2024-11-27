package umc.studymission.web.dto;

import lombok.Getter;
import lombok.Setter;
import umc.studymission.domain.enums.MissionStatus;

@Getter
@Setter
public class MissionRequestDTO {
    private String title;
    private String description;
    private int pointEarned;
    private Long storeId;
    private Long userId;
    private MissionStatus status; // 추가된 필드
}