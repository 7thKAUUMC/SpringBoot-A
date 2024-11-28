package umc.studymission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.studymission.annotation.CheckPage;
import umc.studymission.converter.ReviewConverter;
import umc.studymission.domain.Review;
import umc.studymission.service.ReviewService.ReviewCommandService;
import umc.studymission.service.ReviewService.ReviewQueryService;
import umc.studymission.web.dto.ReviewRequestDTO;
import umc.studymission.web.dto.ReviewResponseDTO;

import java.util.List;

@Tag(name = "리뷰", description = "리뷰 관련 API")
@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;  // ReviewCommandService 사용
    private final ReviewQueryService reviewQueryService;

    @Operation(summary = "가게에 리뷰 추가하기")
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        // 비즈니스 로직 수행 후 Review 객체 생성
        Review review = reviewCommandService.addReview(reviewRequestDTO);  // ReviewCommandService의 addReview 호출

        // Review 객체를 DTO로 변환
        ReviewResponseDTO reviewResponseDTO = ReviewConverter.toReviewResponseDTO(review);

        // DTO를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(reviewResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "유저가 작성한 리뷰 목록 조회")
    @GetMapping("/my-reviews")
    public List<ReviewResponseDTO> getMyReviews(
            @CheckPage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "userId") Long userId) {

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        List<Review> reviews = reviewQueryService.findByUserId(userId, pageRequest).getContent();

        // 여러 Review 객체를 ReviewResponseDTO 리스트로 변환
        return ReviewConverter.toReviewResponseDTOList(reviews);
    }
}
