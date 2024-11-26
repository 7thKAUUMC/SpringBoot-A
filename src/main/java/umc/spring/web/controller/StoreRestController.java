package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.ApiPayload.ApiResponse;
import umc.spring.converter.Store.StoreConverter;
import umc.spring.converter.Store.StoreMissionConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.Store.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.RegisterResultDTO> join(@RequestBody @Valid StoreRequestDTO.RegisterDto request){
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toRegisterResultDTO(store));
    }

    @PostMapping("/{storeId}/missions")
    public ApiResponse<StoreMissionResponseDTO.AddResultDTO> addMission(@PathVariable("storeId") Long storeId, @RequestBody @Valid StoreMissionRequestDTO.AddMissionDTO request){
        Store result = storeCommandService.addMission(storeId, request);
        return ApiResponse.onSuccess(StoreMissionConverter.toAddMissionDTO(result));
    }

    @PostMapping("/{storeId}/missions/{missionId}/challenges")
    public ApiResponse<StoreChallengeResponseDTO> challengMission(
            @PathVariable("storeId") Long storeId,
            @PathVariable("missionId") Long missionId,
            @RequestBody @Valid StoreChallengeRequestDTO request){
        StoreChallengeResponseDTO response = storeCommandService.challengeMission(storeId, missionId, request);
        return ApiResponse.onSuccess(response);
    }
}