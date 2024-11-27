package umc.studymission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.studymission.converter.ReviewConverter;
import umc.studymission.domain.Review;
import umc.studymission.service.ReviewService.ReviewCommandService;
import umc.studymission.web.dto.ReviewRequestDTO;
import umc.studymission.web.dto.ReviewResponseDTO;

@Tag(name = "Review", description = "Review management API")
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;  // ReviewCommandService 사용

    @Operation(summary = "Add a new review for a store")
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        // 비즈니스 로직 수행 후 Review 객체 생성
        Review review = reviewCommandService.addReview(reviewRequestDTO);  // ReviewCommandService의 addReview 호출

        // Review 객체를 DTO로 변환
        ReviewResponseDTO reviewResponseDTO = ReviewConverter.toReviewResponseDTO(review);

        // DTO를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(reviewResponseDTO, HttpStatus.CREATED);
    }

}
