package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPointTransaction is a Querydsl query type for PointTransaction
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPointTransaction extends EntityPathBase<PointTransaction> {

    private static final long serialVersionUID = -170175664L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPointTransaction pointTransaction = new QPointTransaction("pointTransaction");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> earnedPoint = createNumber("earnedPoint", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.study.domain.QMission mission;

    public final DateTimePath<java.time.LocalDateTime> transactionDate = createDateTime("transactionDate", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> usedPoint = createNumber("usedPoint", Long.class);

    public final umc.study.domain.QUser user;

    public QPointTransaction(String variable) {
        this(PointTransaction.class, forVariable(variable), INITS);
    }

    public QPointTransaction(Path<? extends PointTransaction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPointTransaction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPointTransaction(PathMetadata metadata, PathInits inits) {
        this(PointTransaction.class, metadata, inits);
    }

    public QPointTransaction(Class<? extends PointTransaction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.mission = inits.isInitialized("mission") ? new umc.study.domain.QMission(forProperty("mission")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user")) : null;
    }

}

