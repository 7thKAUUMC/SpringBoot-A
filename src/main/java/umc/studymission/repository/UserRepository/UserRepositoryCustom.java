package umc.studymission.repository.UserRepository;

import umc.studymission.domain.User;
import umc.studymission.domain.enums.MemberStatus;

import java.util.List;

public interface UserRepositoryCustom {
    List<User> findUsersByDynamicCriteria(String username, MemberStatus status);
}
