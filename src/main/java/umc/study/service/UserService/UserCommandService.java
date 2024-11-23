package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.User;
import umc.study.repository.UserRepository;
import umc.study.web.dto.UserRequestDTO;
import umc.study.converter.UserConverter;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserRepository userRepository; // UserRepository 의존성 주입

    public User createUser(UserRequestDTO.JoinDto request) {
        // UserConverter를 사용하여 User 엔티티 생성
        User user = UserConverter.toUser(request);

        // DB에 저장
        return userRepository.save(user);
    }
}

