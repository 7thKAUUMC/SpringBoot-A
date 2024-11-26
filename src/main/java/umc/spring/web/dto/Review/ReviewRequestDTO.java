package umc.spring.web.dto.Review;

import lombok.Getter;

@Getter
public class ReviewRequestDTO {
    @Getter
    public static class AddReviewDto {
        private String title;        // 리뷰 제목
        private String description;  // 리뷰 내용
        private Long memberId;       // 작성자 ID
        private Long storeId;        // 가게 ID
    }
}