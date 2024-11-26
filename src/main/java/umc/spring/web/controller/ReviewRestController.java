package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.ApiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> join(@RequestBody @Valid ReviewRequestDTO.AddReviewDto request) {
        var result = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(result);
    }
}