package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreMission is a Querydsl query type for StoreMission
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreMission extends EntityPathBase<StoreMission> {

    private static final long serialVersionUID = -447826633L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreMission storeMission = new QStoreMission("storeMission");

    public final umc.spring.domain.QBaseEntity _super = new umc.spring.domain.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QMission mission;

    public final EnumPath<umc.spring.domain.Enums.MissionStatus> status = createEnum("status", umc.spring.domain.Enums.MissionStatus.class);

    public final umc.spring.domain.QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreMission(String variable) {
        this(StoreMission.class, forVariable(variable), INITS);
    }

    public QStoreMission(Path<? extends StoreMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreMission(PathMetadata metadata, PathInits inits) {
        this(StoreMission.class, metadata, inits);
    }

    public QStoreMission(Class<? extends StoreMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new umc.spring.domain.QMission(forProperty("mission")) : null;
        this.store = inits.isInitialized("store") ? new umc.spring.domain.QStore(forProperty("store")) : null;
    }

}

