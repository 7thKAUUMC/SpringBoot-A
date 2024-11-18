package umc.study.convert;

import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.MRegisterResultDTO toMRegisterResultDTO(Mission mission){
        return MissionResponseDTO.MRegisterResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MRegisterDTO request){

        return Mission.builder()
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .build();
    }
}
