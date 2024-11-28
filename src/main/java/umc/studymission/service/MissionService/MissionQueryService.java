package umc.studymission.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.studymission.domain.Mission;

public interface MissionQueryService {
    Page<Mission> findActiveMissionsByUserId(Long userId, Pageable pageable);
    Page<Mission> findByStoreId(Long storeId, Pageable pageable); // Store ID로 조회
}
