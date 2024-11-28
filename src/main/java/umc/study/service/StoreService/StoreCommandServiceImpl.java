package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.convert.StoreConverter;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService{

    private final StoreRepository storeRepository;

    @Override
    public Store joinStore(StoreRequestDTO.RegisterDto request) {
        Store newStore = StoreConverter.toStore(request);


        return storeRepository.save(newStore);
    }
}