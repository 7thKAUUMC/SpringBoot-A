package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserDelete is a Querydsl query type for UserDelete
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserDelete extends EntityPathBase<UserDelete> {

    private static final long serialVersionUID = 919407576L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserDelete userDelete = new QUserDelete("userDelete");

    public final DateTimePath<java.time.LocalDateTime> deleteAt = createDateTime("deleteAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath reason = createString("reason");

    public final QUser user;

    public QUserDelete(String variable) {
        this(UserDelete.class, forVariable(variable), INITS);
    }

    public QUserDelete(Path<? extends UserDelete> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserDelete(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserDelete(PathMetadata metadata, PathInits inits) {
        this(UserDelete.class, metadata, inits);
    }

    public QUserDelete(Class<? extends UserDelete> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

