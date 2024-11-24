package umc.studymission.repository.StoreRepository;

import umc.studymission.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> findStoresByDynamicCriteria(String name, String region);
}
