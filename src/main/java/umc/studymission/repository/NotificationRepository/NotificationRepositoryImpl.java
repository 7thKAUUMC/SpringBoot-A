package umc.studymission.repository.NotificationRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.Notification;
import umc.studymission.domain.QNotification;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Notification> findNotificationsByDynamicCriteria(Long userId, Boolean readStatus) {
        QNotification notification = QNotification.notification;
        BooleanBuilder predicate = new BooleanBuilder();

        if (userId != null) {
            predicate.and(notification.user.id.eq(userId));
        }

        if (readStatus != null) {
            predicate.and(notification.readStatus.eq(readStatus));
        }

        return jpaQueryFactory
                .selectFrom(notification)
                .where(predicate)
                .fetch();
    }
}
