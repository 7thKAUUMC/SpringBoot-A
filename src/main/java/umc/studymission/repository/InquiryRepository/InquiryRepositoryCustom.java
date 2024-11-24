package umc.studymission.repository.InquiryRepository;

import umc.studymission.domain.Inquiry;

import java.util.List;

public interface InquiryRepositoryCustom {
    List<Inquiry> findByContentContaining(String keyword);
}
