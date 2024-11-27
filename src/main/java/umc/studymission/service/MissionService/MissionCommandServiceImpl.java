package umc.studymission.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.studymission.converter.MissionConverter;
import umc.studymission.domain.Mission;
import umc.studymission.repository.MissionRepository.MissionRepository;
import umc.studymission.repository.StoreRepository.StoreRepository;
import umc.studymission.repository.UserRepository.UserRepository;
import umc.studymission.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO requestDTO) {
        Mission mission = MissionConverter.toMission(requestDTO, storeRepository, userRepository);
        return missionRepository.save(mission);
    }
}
