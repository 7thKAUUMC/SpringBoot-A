package umc.spring.repository.Store;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.StoreMission;

public interface StoreMissionRepository extends JpaRepository<StoreMission, Long> {

    // 특정 Store, Mission, User의 존재 여부를 확인
    boolean existsByStoreIdAndMissionIdAndMemberId(Long storeId, Long missionId, Long memberId);

    Page<StoreMission> findAllByStore(Store store, PageRequest pageRequest);

}