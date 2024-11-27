package umc.studymission.service.StoreService;

import umc.studymission.domain.Store;
import umc.studymission.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store addStore(StoreRequestDTO requestDTO);
}