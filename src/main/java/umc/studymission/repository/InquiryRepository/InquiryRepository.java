package umc.studymission.repository.InquiryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.studymission.domain.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long>, InquiryRepositoryCustom {
}
