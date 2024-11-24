package umc.study.converter;

import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.Restaurant;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

public class ReviewConverter {

    // ReviewRequest DTO를 받아 Review 엔티티를 생성합니다.
    public static Review toEntity(ReviewRequest request, Restaurant restaurant, User user) {
        return Review.builder()
                //.content(request.getComment())  // 이제 리뷰 내용과 평점만 포함되어 있습니다.
                .rating(request.getRating())
                .user(user)
                .restaurant(restaurant)
                .build();
    }

    // Review 엔티티를 받아 ReviewResponse DTO를 생성합니다.
    public static ReviewResponse toDto(Review review) {
        return new ReviewResponse(
                review.getId(),
                review.getRating(),
                review.getComment()
        );
    }
}
