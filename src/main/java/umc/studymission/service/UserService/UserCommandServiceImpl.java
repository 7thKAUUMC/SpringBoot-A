package umc.studymission.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.studymission.converter.UserConverter;
import umc.studymission.domain.User;
import umc.studymission.repository.UserRepository.UserRepository;
import umc.studymission.web.dto.UserRequestDTO;
import umc.studymission.web.dto.UserResponseDTO;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserResponseDTO.CreateResultDto createUser(UserRequestDTO.CreateDto createDto) {
        // 사용자명 중복 확인
        if (userRepository.existsByUsername(createDto.getUsername())) {
            throw new IllegalArgumentException("Username already exists.");
        }

        // 이메일 중복 확인
        if (userRepository.existsByEmail(createDto.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        // DTO -> Entity 변환
        User user = userConverter.toEntity(createDto);

        // 비밀번호 그대로 설정 (암호화 없이 저장)
        user.setPassword(createDto.getPassword());

        // User 엔티티 저장
        User savedUser = userRepository.save(user);

        // Entity -> Response DTO 변환
        return userConverter.toResponseDto(savedUser);
    }
}
