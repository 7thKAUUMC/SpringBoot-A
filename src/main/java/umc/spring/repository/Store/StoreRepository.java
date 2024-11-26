package umc.spring.repository.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Store;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> dynamicQueryWithBooleanBuilder(String name);
}