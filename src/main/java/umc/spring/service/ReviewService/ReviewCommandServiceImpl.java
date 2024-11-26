package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.Member.MemberRepository;
import umc.spring.repository.Review.ReviewRepository;
import umc.spring.repository.Store.StoreRepository;
import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public ReviewResponseDTO.AddReviewResultDTO addReview(ReviewRequestDTO.AddReviewDto request) {
        // 작성자(Member) 조회
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        // 가게(Store) 조회
        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new RuntimeException("Store not found"));

        // Review 엔티티 생성
        Review review = ReviewConverter.toReview(request);
        review.setMember(member);
        review.setStore(store);

        // 저장
        Review savedReview = reviewRepository.save(review);

        // 응답 DTO로 변환
        return ReviewConverter.toAddReviewResultDTO(savedReview);
    }
}