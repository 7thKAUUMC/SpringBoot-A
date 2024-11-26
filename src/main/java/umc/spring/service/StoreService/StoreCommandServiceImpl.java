package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.ApiPayload.code.status.ErrorStatus;
import umc.spring.ApiPayload.exception.handler.MissionHandler;
import umc.spring.ApiPayload.exception.handler.StoreHandler;
import umc.spring.converter.Store.StoreConverter;
import umc.spring.converter.Store.StoreMissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.StoreMission;
import umc.spring.repository.Mission.MissionRepository;
import umc.spring.repository.Store.StoreRepository;
import umc.spring.web.dto.Store.StoreChallengeRequestDTO;
import umc.spring.web.dto.Store.StoreChallengeResponseDTO;
import umc.spring.web.dto.Store.StoreMissionRequestDTO;
import umc.spring.web.dto.Store.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Store joinStore(StoreRequestDTO.RegisterDto request) {
        Store newStore = StoreConverter.toStore(request);

        List<Mission> missionList = request.getStoremission().stream()
                .map(mission -> {
                    return missionRepository.findById(mission).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
                }).collect(Collectors.toList());

        List<StoreMission> storemissionList = StoreMissionConverter.toStoreMissionList(missionList);
        storemissionList.forEach(storeMission -> {storeMission.setStore(newStore);});
        newStore.setStoreMissionList(storemissionList);
        return storeRepository.save(newStore);
    }

    @Override
    public Store addMission(Long storeId, StoreMissionRequestDTO.AddMissionDTO request){
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        StoreMission storeMission = new StoreMission();
        storeMission.setStore(store);
        storeMission.setMission(mission);

        // 4. StoreMission 리스트에 추가
        store.getStoreMissionList().add(storeMission);

        // 5. Store 저장 (StoreMission도 함께 저장)
        return storeRepository.save(store);
    }

    @Override
    public StoreChallengeResponseDTO challengeMission(Long storeId, Long missionId, StoreChallengeRequestDTO request) {
        // 1. 가게와 미션 존재 여부 확인
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        // 2. StoreMission 도전 객체 생성 및 연관 설정
        StoreMission storeMission = StoreMissionConverter.toStoreMission(store, mission);

        // 3. StoreMission 리스트에 추가
        store.getStoreMissionList().add(storeMission);

        // 4. 저장 (StoreMission도 함께 저장)
        storeRepository.save(store);

        // 5. 응답 DTO 반환
        return StoreChallengeResponseDTO.builder()
                .challengeId(storeMission.getId())
                .storeId(store.getId())
                .missionId(mission.getId())
                .message("Mission challenge successfully created.")
                .build();
    }
}