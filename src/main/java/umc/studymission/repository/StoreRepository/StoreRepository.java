package umc.studymission.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
