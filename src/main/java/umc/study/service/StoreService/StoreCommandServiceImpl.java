package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.convert.MemberConverter;
import umc.study.convert.MemberPreferConverter;
import umc.study.convert.StoreConverter;
import umc.study.domain.FoodCategory;
import umc.study.domain.Member;
import umc.study.domain.Store;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

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
