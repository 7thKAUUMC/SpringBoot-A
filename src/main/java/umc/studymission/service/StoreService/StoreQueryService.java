package umc.studymission.service.StoreService;

import umc.studymission.domain.Store;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStoreById(Long storeId);
}
