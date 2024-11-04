package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberEat is a Querydsl query type for MemberEat
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEat extends EntityPathBase<MemberEat> {

    private static final long serialVersionUID = 708482578L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberEat memberEat = new QMemberEat("memberEat");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final umc.spring.domain.QStore store;

    public QMemberEat(String variable) {
        this(MemberEat.class, forVariable(variable), INITS);
    }

    public QMemberEat(Path<? extends MemberEat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberEat(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberEat(PathMetadata metadata, PathInits inits) {
        this(MemberEat.class, metadata, inits);
    }

    public QMemberEat(Class<? extends MemberEat> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.store = inits.isInitialized("store") ? new umc.spring.domain.QStore(forProperty("store")) : null;
    }

}

