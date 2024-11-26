package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import umc.spring.repository.Store.StoreMissionRepository;
import umc.spring.validation.annotation.StoreChallengeValid;
import umc.spring.web.dto.Store.StoreChallengeRequestDTO;

@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<StoreChallengeValid, StoreChallengeRequestDTO> {

    private final StoreMissionRepository storeMissionRepository;

    @Override
    public boolean isValid(StoreChallengeRequestDTO request, ConstraintValidatorContext context) {
        // DB에서 해당 미션이 이미 도전 중인지 확인
        boolean isAlreadyChallenged = storeMissionRepository.existsByStoreIdAndMissionIdAndMemberId(
                request.getStoreId(),
                request.getMissionId(),
                request.getMemberId()
        );

        // true면 유효, false면 예외 발생
        return !isAlreadyChallenged;
    }
}