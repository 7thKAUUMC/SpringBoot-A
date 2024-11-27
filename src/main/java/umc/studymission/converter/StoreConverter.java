package umc.studymission.converter;

import umc.studymission.domain.Store;
import umc.studymission.web.dto.StoreRequestDTO;
import umc.studymission.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO requestDTO) {
        return Store.builder()
                .name(requestDTO.getName())
                .region(requestDTO.getRegion())
                .build();
    }

    public static StoreResponseDTO toStoreResponseDTO(Store store) {
        return new StoreResponseDTO(store.getId(), store.getName(), store.getRegion());
    }
}
