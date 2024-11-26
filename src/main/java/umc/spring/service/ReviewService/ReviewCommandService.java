package umc.spring.service.ReviewService;

import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO.AddReviewResultDTO addReview(ReviewRequestDTO.AddReviewDto request);
}