package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.Store.StoreChallengeRequestDTO;
import umc.spring.web.dto.Store.StoreChallengeResponseDTO;
import umc.spring.web.dto.Store.StoreMissionRequestDTO;
import umc.spring.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.RegisterDto request);
    Store addMission(Long storeId, StoreMissionRequestDTO.AddMissionDTO request);
    StoreChallengeResponseDTO challengeMission(Long storeId, Long missionId, StoreChallengeRequestDTO request);
}