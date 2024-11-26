package umc.spring.repository.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}