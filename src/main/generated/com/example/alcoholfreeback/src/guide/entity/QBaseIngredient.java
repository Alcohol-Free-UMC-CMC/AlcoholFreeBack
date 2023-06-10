package com.example.alcoholfreeback.src.guide.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseIngredient is a Querydsl query type for BaseIngredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBaseIngredient extends EntityPathBase<BaseIngredient> {

    private static final long serialVersionUID = 658043155L;

    public static final QBaseIngredient baseIngredient = new QBaseIngredient("baseIngredient");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final StringPath name = createString("name");

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QBaseIngredient(String variable) {
        super(BaseIngredient.class, forVariable(variable));
    }

    public QBaseIngredient(Path<? extends BaseIngredient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseIngredient(PathMetadata metadata) {
        super(BaseIngredient.class, metadata);
    }

}

