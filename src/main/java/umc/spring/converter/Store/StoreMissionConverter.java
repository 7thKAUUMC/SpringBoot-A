package umc.spring.converter.Store;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.StoreMission;
import umc.spring.web.dto.Store.StoreMissionResponseDTO;
import umc.spring.web.dto.Store.StoreResponseDTO;

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

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(StoreMission storeMission) {
        String ownerNickname = storeMission.getMember() != null ? storeMission.getMember().getName() : "Unknown";

        return StoreResponseDTO.MissionPreViewDTO.builder()
                .ownerNickname(ownerNickname)
                .createdAt(storeMission.getCreatedAt().toLocalDate())
                .description(storeMission.getMission().getDescription())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<StoreMission> missionList){

        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}