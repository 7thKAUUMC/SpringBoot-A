package umc.studymission.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.studymission.converter.ReviewConverter;
import umc.studymission.domain.Review;
import umc.studymission.repository.MissionRepository.MissionRepository;
import umc.studymission.repository.ReviewRepository.ReviewRepository;
import umc.studymission.repository.StoreRepository.StoreRepository;
import umc.studymission.repository.UserRepository.UserRepository;
import umc.studymission.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository; // 추가

    @Override
    @Transactional
    public Review addReview(ReviewRequestDTO requestDTO) {
        // ReviewConverter에 MissionRepository 추가
        Review review = ReviewConverter.toReview(requestDTO, storeRepository, userRepository, missionRepository);
        return reviewRepository.save(review);
    }
}
