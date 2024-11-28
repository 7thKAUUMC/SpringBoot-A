package umc.studymission.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.studymission.domain.Review;
import umc.studymission.repository.ReviewRepository.ReviewRepository;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> findByUserId(Long userId, Pageable pageable) {
        return reviewRepository.findByUserId(userId, pageable);
    }
}
