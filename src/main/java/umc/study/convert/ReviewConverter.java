package umc.study.convert;

import umc.study.domain.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;


import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.RRegisterResultDTO toRegisterResultDTO(Review review){
        return ReviewResponseDTO.RRegisterResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.RRegisterDto request){

        return Review.builder()
                .title(request.getTitle())
                .build();
    }
}
