package umc.studymission.repository.MissionRepository;

import umc.studymission.domain.Mission;
import umc.studymission.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByDynamicCriteria(String title, MissionStatus status, Integer pointEarned);
}
