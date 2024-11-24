package umc.studymission.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.QReview;
import umc.studymission.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Review> findReviewsByDynamicCriteria(Integer rating, Long storeId) {
        QReview review = QReview.review;
        BooleanBuilder predicate = new BooleanBuilder();

        if (rating != null) {
            predicate.and(review.rating.goe(rating));
        }

        if (storeId != null) {
            predicate.and(review.store.id.eq(storeId));
        }

        return jpaQueryFactory
                .selectFrom(review)
                .where(predicate)
                .fetch();
    }
}
