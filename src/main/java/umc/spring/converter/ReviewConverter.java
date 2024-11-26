package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.AddReviewDto request) {
        return Review.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .build();
    }

    public static ReviewResponseDTO.AddReviewResultDTO toAddReviewResultDTO(Review review) {
        return ReviewResponseDTO.AddReviewResultDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .description(review.getDescription())
                .createdAt(review.getCreatedAt().toString())
                .build();
    }
}