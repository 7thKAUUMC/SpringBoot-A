package umc.studymission.repository.NotificationRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>, NotificationRepositoryCustom {
}
