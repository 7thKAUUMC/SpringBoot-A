package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.UserConverter;
import umc.study.domain.User;
import umc.study.service.UserService.UserCommandService;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")  // 엔드포인트 변경
public class UserRestController {

    private final UserCommandService userCommandService;  // UserCommandService로 변경

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request) {
        // 요청 DTO를 받아 서비스 호출
        User user = userCommandService.createUser(request);

        // 변환 후 반환
        UserResponseDTO.JoinResultDTO response = UserConverter.toJoinResultDTO(user);
        return ApiResponse.onSuccess(response); // ApiResponse 성공 응답
    }
}

