package umc.studymission.service.MissionService;

import umc.studymission.domain.Mission;
import umc.studymission.web.dto.MissionRequestDTO;

public interface MissionCommandService {
    Mission addMission(MissionRequestDTO requestDTO);
}
