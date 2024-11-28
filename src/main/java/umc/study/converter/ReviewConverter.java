package umc.study.converter;

import org.springframework.stereotype.Component;
import umc.study.domain.Review;
import umc.study.domain.User;
import umc.study.domain.Restaurant;
import umc.study.web.dto.ReviewRequest;
import umc.study.web.dto.ReviewResponse;

// converter/ReviewConverter.java
@Component
public class ReviewConverter {

    public static Review toReview(Restaurant restaurant, ReviewRequest request) {
        return Review.builder()
                .restaurant(restaurant)
                .rating(request.getRating())
                .Comment(request.getComment())
                .build();
    }

    public static ReviewResponse toReviewResponse(Review review) {
        return ReviewResponse.builder()
                .reviewId(review.getId())
                .rating(review.getRating())
                .comment(review.getComment())
                .build();
    }
}