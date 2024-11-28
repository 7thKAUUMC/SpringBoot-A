package umc.studymission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.studymission.domain.Mission;
import umc.studymission.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> findActiveMissionsByUserId(Long userId, Pageable pageable) {
        return missionRepository.findByUserIdAndStatus(userId, "ACTIVE", pageable);
    }

    @Override
    public Page<Mission> findByStoreId(Long storeId, Pageable pageable) {
        return missionRepository.findByStoreId(storeId, pageable);
    }
}
