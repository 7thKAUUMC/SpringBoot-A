package umc.studymission.repository.PointRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.mapping.Point;
import umc.studymission.domain.mapping.QPoint;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Point> findPointsByDynamicCriteria(Long userId, Long missionId) {
        QPoint point = QPoint.point;
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(point.user.id.eq(userId));
        }

        if (missionId != null) {
            predicate.and(point.mission.id.eq(missionId));
        }

        return jpaQueryFactory
                .selectFrom(point)
                .where(predicate)
                .fetch();
    }
}
