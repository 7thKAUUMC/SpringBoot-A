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

import java.util.List;
import java.util.stream.Collectors;

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
        // Review에서 user와 store의 ID만 넘겨주도록 수정
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .rating(review.getRating())
                .content(review.getContent())
                .user(review.getUser().getId())  // User의 ID를 Long으로 반환
                .store(review.getStore().getId())  // Store의 ID를 Long으로 반환
                .build();
    }

    // 여러 Review 객체를 List<ReviewResponseDTO>로 변환하는 메서드
    public static List<ReviewResponseDTO> toReviewResponseDTOList(List<Review> reviews) {
        return reviews.stream()
                .map(ReviewConverter::toReviewResponseDTO)  // 각 Review를 ReviewResponseDTO로 변환
                .collect(Collectors.toList());  // List로 수집
    }
}
