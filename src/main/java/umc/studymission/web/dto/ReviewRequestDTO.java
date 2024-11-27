package umc.studymission.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewRequestDTO {
    private int rating;
    private String content;
    private Long storeId;
    private Long userId;
    private Long missionId;
}