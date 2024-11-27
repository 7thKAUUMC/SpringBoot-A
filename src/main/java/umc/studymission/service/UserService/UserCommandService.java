package umc.studymission.service.UserService;

import umc.studymission.web.dto.UserRequestDTO;
import umc.studymission.web.dto.UserResponseDTO;

public interface UserCommandService {
    UserResponseDTO.CreateResultDto createUser(UserRequestDTO.CreateDto createDto);
}
