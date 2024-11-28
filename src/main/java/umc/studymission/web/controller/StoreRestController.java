package umc.studymission.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.studymission.converter.StoreConverter;
import umc.studymission.domain.Store;
import umc.studymission.service.StoreService.StoreCommandService;
import umc.studymission.web.dto.StoreRequestDTO;
import umc.studymission.web.dto.StoreResponseDTO;

@Tag(name = "가게", description = "가게 관련 API")
@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreCommandService storeCommandService;  // StoreCommandService 사용

    @Operation(summary = "새로운 가게 추가하기")
    @PostMapping
    public ResponseEntity<StoreResponseDTO> addStore(@RequestBody StoreRequestDTO storeRequestDTO) {
        // 비즈니스 로직 수행 후 Store 객체 생성
        Store store = storeCommandService.addStore(storeRequestDTO);  // StoreCommandService의 addStore 호출

        // Store 객체를 DTO로 변환
        StoreResponseDTO storeResponseDTO = StoreConverter.toStoreResponseDTO(store);

        // DTO를 ResponseEntity에 담아 반환
        return new ResponseEntity<>(storeResponseDTO, HttpStatus.CREATED);
    }
}
