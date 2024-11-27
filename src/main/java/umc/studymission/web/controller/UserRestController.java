package umc.studymission.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.studymission.service.UserService.UserCommandService;
import umc.studymission.web.dto.UserRequestDTO;
import umc.studymission.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping
    public ResponseEntity<UserResponseDTO.CreateResultDto> addUser(
            @RequestBody @Valid UserRequestDTO.CreateDto createDto) {
        UserResponseDTO.CreateResultDto result = userCommandService.createUser(createDto);
        return ResponseEntity.ok(result);
    }
}
