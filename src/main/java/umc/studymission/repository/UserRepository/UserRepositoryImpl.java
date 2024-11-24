package umc.studymission.repository.UserRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.studymission.domain.QUser;
import umc.studymission.domain.User;
import umc.studymission.domain.enums.MemberStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> findUsersByDynamicCriteria(String username, MemberStatus status) {
        QUser user = QUser.user;
        BooleanBuilder predicate = new BooleanBuilder();

        if (username != null) {
            predicate.and(user.username.eq(username));
        }

        if (status != null) {
            predicate.and(user.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(user)
                .where(predicate)
                .fetch();
    }
}
