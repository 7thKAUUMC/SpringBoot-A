package umc.studymission.service.StoreService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.studymission.converter.StoreConverter;
import umc.studymission.domain.Store;
import umc.studymission.repository.StoreRepository.StoreRepository;
import umc.studymission.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Store addStore(StoreRequestDTO requestDTO) {
        Store store = StoreConverter.toStore(requestDTO);
        return storeRepository.save(store);
    }
}
