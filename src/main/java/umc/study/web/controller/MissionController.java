package umc.study.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import umc.study.apiPayload.ApiResponse;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.service.MissionService;
import umc.study.validation.annotation.ValidMissionChallenge;
import umc.study.web.dto.MissionChallengeRequest;
import umc.study.web.dto.MissionChallengeResponse;

@Slf4j
@RestController
@RequestMapping("/api/missions")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping("/{missionId}/challenges")
    public ResponseEntity<ApiResponse<MissionChallengeResponse>> challengeMission(
            @PathVariable @ValidMissionChallenge(message = "MISSION_NOT_VALID") Long missionId,
            @Valid @RequestBody MissionChallengeRequest request) {

        log.info("Received request to challenge mission. MissionId: {}, UserId: {}",
                missionId, request.getUserId());

        try {
            MissionChallengeResponse response = missionService.challengeMission(missionId, request);
            return ResponseEntity.ok(ApiResponse.onSuccess(response));
        } catch (Exception e) {
            log.error("Error while challenging mission", e);
            return ResponseEntity.badRequest()
                    .body(ApiResponse.onFailure(ErrorStatus.MISSION_NOT_VALID.getCode(),
                            ErrorStatus.MISSION_NOT_VALID.getMessage(), null));
        }
    }
}