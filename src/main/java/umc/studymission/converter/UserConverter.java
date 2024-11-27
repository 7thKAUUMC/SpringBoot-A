package umc.studymission.converter;

import org.springframework.stereotype.Component;
import umc.studymission.domain.User;
import umc.studymission.web.dto.UserRequestDTO;
import umc.studymission.web.dto.UserResponseDTO;

@Component
public class UserConverter {

    // UserRequestDTO -> User 엔티티 변환
    public User toEntity(UserRequestDTO.CreateDto createDto) {
        return User.builder()
                .username(createDto.getUsername())
                .email(createDto.getEmail())
                .password(createDto.getPassword()) // 패스워드는 암호화하기 전 원본 그대로 저장
                .likes(createDto.getLikes())
                .phoneNumber(createDto.getPhoneNumber())
                .status(createDto.getStatus())
                .build();
    }

    // User -> UserResponseDTO.CreateResultDto 변환
    public UserResponseDTO.CreateResultDto toResponseDto(User user) {
        return UserResponseDTO.CreateResultDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
