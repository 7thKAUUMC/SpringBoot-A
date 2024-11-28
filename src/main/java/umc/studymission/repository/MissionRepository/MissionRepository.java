package umc.studymission.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {
    Page<Mission> findByUserIdAndStatus(Long userId, String status, Pageable pageable);
    Page<Mission> findByStoreId(Long storeId, Pageable pageable); // storeId로 조회
}
