package umc.study.convert;

import umc.study.domain.Store;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.RegisterResultDTO toRegisterResultDTO(Store store){
        return StoreResponseDTO.RegisterResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.RegisterDto request){

        return Store.builder()
                .address(request.getAddress())
                .name(request.getName())
                .build();
    }
}
