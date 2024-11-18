package umc.study.StoreService;

import umc.study.domain.mapping.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    List<Object> findStoresByNameAndScore(String name, Float score);
}