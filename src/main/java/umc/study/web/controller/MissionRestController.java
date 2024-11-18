package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.convert.MemberConverter;
import umc.study.convert.MissionConverter;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.service.MissionService.MissionCommandService;
import umc.study.web.dto.MissionResponseDTO;
import umc.study.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.MRegisterResultDTO> join(@RequestBody @Valid MissionRequestDTO.MRegisterDTO request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMRegisterResultDTO(mission));
    }
}