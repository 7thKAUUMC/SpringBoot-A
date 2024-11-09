package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNewEventNotification is a Querydsl query type for NewEventNotification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNewEventNotification extends EntityPathBase<NewEventNotification> {

    private static final long serialVersionUID = 491551463L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNewEventNotification newEventNotification = new QNewEventNotification("newEventNotification");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isConfirmed = createBoolean("isConfirmed");

    public final StringPath message = createString("message");

    public final QMission mission;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QNewEventNotification(String variable) {
        this(NewEventNotification.class, forVariable(variable), INITS);
    }

    public QNewEventNotification(Path<? extends NewEventNotification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNewEventNotification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNewEventNotification(PathMetadata metadata, PathInits inits) {
        this(NewEventNotification.class, metadata, inits);
    }

    public QNewEventNotification(Class<? extends NewEventNotification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

