package umc.study.converter;

import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user) {
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .nickname(user.getNickname()) // 닉네임 추가
                .email(user.getEmail()) // 이메일 추가
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request) {
        Gender gender = null;

        switch (request.getGender()) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return User.builder()
                .phoneNum(request.getPhoneNum())  // 전화번호 설정
                .email(request.getEmail())        // 이메일 설정
                .nickname(request.getNickname())  // 닉네임 설정
                .password(request.getPassword())  // 비밀번호 설정
                .name(request.getName())          // 이름 설정
                .gender(gender)                   // Gender Enum 설정
                .birthday(request.getBirthday())  // 생일 설정
                .address(request.getAddress())    // 주소 설정
                .totalPoint(0L)                   // 기본 포인트 설정
                //.userPreferList(new ArrayList<>())
                .build();
    }
}
