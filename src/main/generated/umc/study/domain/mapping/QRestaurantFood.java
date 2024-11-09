package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurantFood is a Querydsl query type for RestaurantFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantFood extends EntityPathBase<RestaurantFood> {

    private static final long serialVersionUID = 912969181L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurantFood restaurantFood = new QRestaurantFood("restaurantFood");

    public final umc.study.domain.QFood food;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.study.domain.QRestaurant restaurant;

    public QRestaurantFood(String variable) {
        this(RestaurantFood.class, forVariable(variable), INITS);
    }

    public QRestaurantFood(Path<? extends RestaurantFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurantFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurantFood(PathMetadata metadata, PathInits inits) {
        this(RestaurantFood.class, metadata, inits);
    }

    public QRestaurantFood(Class<? extends RestaurantFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new umc.study.domain.QFood(forProperty("food")) : null;
        this.restaurant = inits.isInitialized("restaurant") ? new umc.study.domain.QRestaurant(forProperty("restaurant")) : null;
    }

}

