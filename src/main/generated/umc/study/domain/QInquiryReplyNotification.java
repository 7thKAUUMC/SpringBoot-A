package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryReplyNotification is a Querydsl query type for InquiryReplyNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryReplyNotification extends EntityPathBase<InquiryReplyNotification> {

    private static final long serialVersionUID = -29170448L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryReplyNotification inquiryReplyNotification = new QInquiryReplyNotification("inquiryReplyNotification");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QInquiryReply inquiryReply;

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final StringPath message = createString("message");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QInquiryReplyNotification(String variable) {
        this(InquiryReplyNotification.class, forVariable(variable), INITS);
    }

    public QInquiryReplyNotification(Path<? extends InquiryReplyNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryReplyNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryReplyNotification(PathMetadata metadata, PathInits inits) {
        this(InquiryReplyNotification.class, metadata, inits);
    }

    public QInquiryReplyNotification(Class<? extends InquiryReplyNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiryReply = inits.isInitialized("inquiryReply") ? new QInquiryReply(forProperty("inquiryReply"), inits.get("inquiryReply")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

