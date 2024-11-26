package umc.spring.converter.Store;

import umc.spring.domain.Store;
import umc.spring.web.dto.Store.StoreRequestDTO;
import umc.spring.web.dto.Store.StoreResponseDTO;

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