package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserRestaurantRating is a Querydsl query type for UserRestaurantRating
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserRestaurantRating extends EntityPathBase<UserRestaurantRating> {

    private static final long serialVersionUID = -1422444249L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserRestaurantRating userRestaurantRating = new QUserRestaurantRating("userRestaurantRating");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<umc.study.domain.enums.Rating> rating = createEnum("rating", umc.study.domain.enums.Rating.class);

    public final DateTimePath<java.time.LocalDateTime> ratingDate = createDateTime("ratingDate", java.time.LocalDateTime.class);

    public final QRestaurant restaurant;

    public final StringPath review = createString("review");

    public final QReview reviewEntity;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final QUser user;

    public QUserRestaurantRating(String variable) {
        this(UserRestaurantRating.class, forVariable(variable), INITS);
    }

    public QUserRestaurantRating(Path<? extends UserRestaurantRating> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserRestaurantRating(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserRestaurantRating(PathMetadata metadata, PathInits inits) {
        this(UserRestaurantRating.class, metadata, inits);
    }

    public QUserRestaurantRating(Class<? extends UserRestaurantRating> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant")) : null;
        this.reviewEntity = inits.isInitialized("reviewEntity") ? new QReview(forProperty("reviewEntity"), inits.get("reviewEntity")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

