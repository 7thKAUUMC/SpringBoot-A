package umc.studymission.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.studymission.domain.Store;
import umc.studymission.repository.StoreRepository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;

    @Override
    public Optional<Store> findStoreById(Long storeId) {
        return storeRepository.findById(storeId);
    }
}
