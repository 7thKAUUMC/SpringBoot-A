package umc.studymission.repository.InquiryRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.Inquiry;
import umc.studymission.domain.QInquiry;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InquiryRepositoryImpl implements InquiryRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Inquiry> findByContentContaining(String keyword) {
        QInquiry inquiry = QInquiry.inquiry;
        BooleanBuilder predicate = new BooleanBuilder();

        if (keyword != null && !keyword.isEmpty()) {
            predicate.and(inquiry.content.containsIgnoreCase(keyword));
        }

        return jpaQueryFactory
                .selectFrom(inquiry)
                .where(predicate)
                .fetch();
    }
}
