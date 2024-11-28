package umc.study.service.MissionService;

import umc.study.domain.Mission;
import umc.study.domain.mapping.MissionStatus;
import umc.study.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission joinMission(MissionRequestDTO.MRegisterDTO request);

    void updateMissionStatus(Long missionId, MissionStatus status);
}
