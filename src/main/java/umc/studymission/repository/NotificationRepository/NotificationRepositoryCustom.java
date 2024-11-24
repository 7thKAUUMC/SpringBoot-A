package umc.studymission.repository.NotificationRepository;

import umc.studymission.domain.Notification;

import java.util.List;

public interface NotificationRepositoryCustom {
    List<Notification> findNotificationsByDynamicCriteria(Long userId, Boolean readStatus);
}
