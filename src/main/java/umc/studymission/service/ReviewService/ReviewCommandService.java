    package umc.studymission.service.ReviewService;

    import umc.studymission.domain.Review;
    import umc.studymission.web.dto.ReviewRequestDTO;

    public interface ReviewCommandService {
        Review addReview(ReviewRequestDTO requestDTO);
    }
