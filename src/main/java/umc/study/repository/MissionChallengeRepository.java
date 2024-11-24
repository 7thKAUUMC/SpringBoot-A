package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.MissionChallenge;
import umc.study.domain.enums.MissionStatus;

public interface MissionChallengeRepository extends JpaRepository<MissionChallenge, Long> {
    boolean existsByMission_IdAndStatus(Long missionId, MissionStatus status);
}