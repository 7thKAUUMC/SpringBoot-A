package umc.studymission.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
}
