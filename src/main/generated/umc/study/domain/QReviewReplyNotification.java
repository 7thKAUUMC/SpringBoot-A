package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewReplyNotification is a Querydsl query type for ReviewReplyNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewReplyNotification extends EntityPathBase<ReviewReplyNotification> {

    private static final long serialVersionUID = 1669363003L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewReplyNotification reviewReplyNotification = new QReviewReplyNotification("reviewReplyNotification");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final StringPath message = createString("message");

    public final QReviewReply reviewReply;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QReviewReplyNotification(String variable) {
        this(ReviewReplyNotification.class, forVariable(variable), INITS);
    }

    public QReviewReplyNotification(Path<? extends ReviewReplyNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewReplyNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewReplyNotification(PathMetadata metadata, PathInits inits) {
        this(ReviewReplyNotification.class, metadata, inits);
    }

    public QReviewReplyNotification(Class<? extends ReviewReplyNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reviewReply = inits.isInitialized("reviewReply") ? new QReviewReply(forProperty("reviewReply"), inits.get("reviewReply")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

