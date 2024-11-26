package umc.spring.converter.Store;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.StoreMission;
import umc.spring.web.dto.Store.StoreMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreMissionConverter {
    public static List<StoreMission> toStoreMissionList(List<Mission> missionList){

        return missionList.stream()
                .map(mission ->
                        StoreMission.builder()
                                .mission(mission)
                                .build()
                ).collect(Collectors.toList());
    }

    public static StoreMissionResponseDTO.AddResultDTO toAddMissionDTO(Store store) {
        return StoreMissionResponseDTO.AddResultDTO.builder()
                .storeId(store.getId()) // Store ID를 가져옵니다.
                .build();
    }

    public static StoreMission toStoreMission(Store store, Mission mission) {
        return StoreMission.builder()
                .store(store)
                .mission(mission)
                .build();
    }
}