package umc.study.repository.StoreRepository;



import umc.study.domain.mapping.Store;

import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}