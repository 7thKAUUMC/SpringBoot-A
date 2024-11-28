package umc.studymission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.studymission.annotation.CheckPage;
import umc.studymission.converter.MissionConverter;
import umc.studymission.domain.Mission;
import umc.studymission.service.MissionService.MissionCommandService;
import umc.studymission.service.MissionService.MissionQueryService;
import umc.studymission.web.dto.MissionRequestDTO;
import umc.studymission.web.dto.MissionResponseDTO;

@Tag(name = "미션", description = "미션관련 API")
@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionCommandService missionCommandService;  // MissionCommandService 사용
    private final MissionQueryService missionQueryService;

    @Operation(summary = "가게에 미션 추가하기")
    @PostMapping
    public ResponseEntity<MissionResponseDTO> addMission(@RequestBody MissionRequestDTO missionRequestDTO) {
        // 비즈니스 로직 수행 후 Mission 객체 생성
        Mission mission = missionCommandService.addMission(missionRequestDTO);  // MissionCommandService의 addMission 호출

        // Mission 객체를 DTO로 변환
        MissionResponseDTO missionResponseDTO = MissionConverter.toMissionResponseDTO(mission);

        // DTO를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(missionResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "특정 가게의 미션 목록", description = "가게 ID를 기반으로 미션 목록을 조회합니다.")
    @GetMapping("/store-missions")
    public Page<Mission> getMissionsByStore(
            @RequestParam(name = "storeId") Long storeId,
            @RequestParam(name = "page") Integer page
    ) {
        Pageable pageable = PageRequest.of(page - 1, 10); // 1 기반 page를 0으로 변환
        return missionQueryService.findByStoreId(storeId, pageable);
    }
    //    public Page<MissionResponseDTO> getStoreMissions(
//            @CheckPage @RequestParam(name = "page") Integer page,
//            @RequestParam(name = "size", defaultValue = "10") Integer size,
//            @RequestParam(name = "storeId") Long storeId) {
//
//        PageRequest pageRequest = PageRequest.of(page - 1, size);
//        Page<Mission> missions = missionQueryService.findByStoreId(storeId, pageRequest);
//
//        return missions.map(MissionConverter::toMissionResponseDTO);
//    }


    @Operation(summary = "내가 진행중인 미션 목록")
    @GetMapping("/my-active-missions")
    public Page<MissionResponseDTO> getMyActiveMissions(
            @CheckPage @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size", defaultValue = "10") Integer size,
            @RequestParam(name = "userId") Long userId) {

        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Mission> missions = missionQueryService.findActiveMissionsByUserId(userId, pageRequest);

        return missions.map(MissionConverter::toMissionResponseDTO);
    }

    // 얘는 나중에 하자
//    @Operation(summary = "진행중인 미션상태 바꾸기")
//    @PatchMapping("/{missionId}/complete")
//    public ResponseEntity<Void> completeMission(@PathVariable Long missionId) {
//        missionCommandService.markMissionAsCompleted(missionId);
//        return ResponseEntity.noContent().build();
//    }
}
