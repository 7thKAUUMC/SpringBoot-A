package umc.spring.web.dto.Review;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class AddReviewResultDTO {
        private Long reviewId;       // 리뷰 ID
        private String title;        // 리뷰 제목
        private String description;  // 리뷰 내용
        private String createdAt;    // 리뷰 생성 시간
    }
}
