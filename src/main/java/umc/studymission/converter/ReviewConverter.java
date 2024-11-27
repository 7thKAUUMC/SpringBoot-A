package umc.studymission.converter;

import umc.studymission.domain.Mission;
import umc.studymission.domain.Review;
import umc.studymission.domain.Store;
import umc.studymission.domain.User;
import umc.studymission.repository.MissionRepository.MissionRepository;
import umc.studymission.repository.StoreRepository.StoreRepository;
import umc.studymission.repository.UserRepository.UserRepository;
import umc.studymission.web.dto.ReviewRequestDTO;
import umc.studymission.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO requestDTO, StoreRepository storeRepository, UserRepository userRepository,  MissionRepository missionRepository) {
        Store store = storeRepository.findById(requestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + requestDTO.getStoreId()));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + requestDTO.getUserId()));

        // Mission을 가져오는 부분 추가
        Mission mission = missionRepository.findById(requestDTO.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found with ID: " + requestDTO.getMissionId()));

        return Review.builder()
                .rating(requestDTO.getRating())
                .content(requestDTO.getContent())
                .store(store)
                .user(user)
                .mission(mission) // Mission을 설정
                .build();
    }

    public static ReviewResponseDTO toReviewResponseDTO(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getRating(),
                review.getContent(),
                review.getUser(),
                review.getStore()
        );
    }
}
