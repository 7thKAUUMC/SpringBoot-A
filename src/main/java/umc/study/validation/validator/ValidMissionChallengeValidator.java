package umc.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.enums.MissionStatus;
import umc.study.repository.MissionChallengeRepository;
import umc.study.repository.MissionRepository;
import umc.study.validation.annotation.ValidMissionChallenge;

@Slf4j
@Component
public class ValidMissionChallengeValidator implements ConstraintValidator<ValidMissionChallenge, Long> {

    private final MissionChallengeRepository missionChallengeRepository;
    private final MissionRepository missionRepository;

    public ValidMissionChallengeValidator(MissionChallengeRepository missionChallengeRepository,
                                          MissionRepository missionRepository) {
        this.missionChallengeRepository = missionChallengeRepository;
        this.missionRepository = missionRepository;
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        log.info("Validating mission with id: {}", missionId);

        if (missionId == null) {
            log.error("Mission ID is null");
            addConstraintViolation(context, ErrorStatus.MISSION_NOT_VALID);
            return false;
        }

        boolean missionExists = missionRepository.existsById(missionId);
        log.info("Mission exists: {}", missionExists);

        if (!missionExists) {
            log.error("Mission not found with id: {}", missionId);
            addConstraintViolation(context, ErrorStatus.MISSION_NOT_FOUND);
            return false;
        }

        boolean alreadyChallenging = missionChallengeRepository.existsByMission_IdAndStatus(missionId, MissionStatus.진행중);
        log.info("Mission already challenging: {}", alreadyChallenging);

        if (alreadyChallenging) {
            log.error("Mission is already in progress: {}", missionId);
            addConstraintViolation(context, ErrorStatus.MISSION_ALREADY_IN_PROGRESS);
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, ErrorStatus errorStatus) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorStatus.name())
                .addConstraintViolation();
    }
}