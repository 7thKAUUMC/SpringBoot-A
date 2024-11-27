package umc.studymission.converter;

import umc.studymission.domain.Mission;
import umc.studymission.domain.Store;
import umc.studymission.domain.User;
import umc.studymission.repository.StoreRepository.StoreRepository;
import umc.studymission.repository.UserRepository.UserRepository;
import umc.studymission.web.dto.MissionRequestDTO;
import umc.studymission.web.dto.MissionResponseDTO;

public class MissionConverter {

    public static Mission toMission(MissionRequestDTO requestDTO, StoreRepository storeRepository, UserRepository userRepository) {
        Store store = storeRepository.findById(requestDTO.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + requestDTO.getStoreId()));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + requestDTO.getUserId()));

        return Mission.builder()
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .status(requestDTO.getStatus())
                .pointEarned(requestDTO.getPointEarned())
                .store(store)
                .user(user)
                .build();
    }


    public static MissionResponseDTO toMissionResponseDTO(Mission mission) {
        return new MissionResponseDTO(
                mission.getId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getStatus(),
                mission.getPointEarned(),
                mission.getStore(),
                mission.getUser()
        );
    }
}
