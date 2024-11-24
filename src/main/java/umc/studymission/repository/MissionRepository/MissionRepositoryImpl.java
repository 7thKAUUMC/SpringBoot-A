package umc.studymission.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.Mission;
import umc.studymission.domain.QMission;
import umc.studymission.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Mission> findMissionsByDynamicCriteria(String title, MissionStatus status, Integer pointEarned) {
        QMission mission = QMission.mission;
        BooleanBuilder predicate = new BooleanBuilder();

        if (title != null) {
            predicate.and(mission.title.containsIgnoreCase(title));
        }

        if (status != null) {
            predicate.and(mission.status.eq(status));
        }

        if (pointEarned != null) {
            predicate.and(mission.pointEarned.goe(pointEarned));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch();
    }
}
