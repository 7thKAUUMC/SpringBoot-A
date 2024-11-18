package umc.spring.service.StoreService;

import jakarta.transaction.Transactional;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store joinStore(StoreRequestDTO.RegisterDto request);
}