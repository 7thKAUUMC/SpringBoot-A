package umc.studymission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.studymission.converter.MissionConverter;
import umc.studymission.domain.Mission;
import umc.studymission.service.MissionService.MissionCommandService;
import umc.studymission.web.dto.MissionRequestDTO;
import umc.studymission.web.dto.MissionResponseDTO;

@Tag(name = "Mission", description = "Mission management API")
@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;  // MissionCommandService 사용

    @Operation(summary = "Add a mission to a store")
    @PostMapping
    public ResponseEntity<MissionResponseDTO> addMission(@RequestBody MissionRequestDTO missionRequestDTO) {
        // 비즈니스 로직 수행 후 Mission 객체 생성
        Mission mission = missionCommandService.addMission(missionRequestDTO);  // MissionCommandService의 addMission 호출

        // Mission 객체를 DTO로 변환
        MissionResponseDTO missionResponseDTO = MissionConverter.toMissionResponseDTO(mission);

        // DTO를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(missionResponseDTO, HttpStatus.CREATED);
    }
}
