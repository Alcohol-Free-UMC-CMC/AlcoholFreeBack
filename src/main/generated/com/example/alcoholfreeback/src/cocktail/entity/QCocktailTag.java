package com.example.alcoholfreeback.src.cocktail.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCocktailTag is a Querydsl query type for CocktailTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCocktailTag extends EntityPathBase<CocktailTag> {

    private static final long serialVersionUID = 744809133L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCocktailTag cocktailTag = new QCocktailTag("cocktailTag");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    public final QCocktail cocktail;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    public final QTag tag;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCocktailTag(String variable) {
        this(CocktailTag.class, forVariable(variable), INITS);
    }

    public QCocktailTag(Path<? extends CocktailTag> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCocktailTag(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCocktailTag(PathMetadata metadata, PathInits inits) {
        this(CocktailTag.class, metadata, inits);
    }

    public QCocktailTag(Class<? extends CocktailTag> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cocktail = inits.isInitialized("cocktail") ? new QCocktail(forProperty("cocktail")) : null;
        this.tag = inits.isInitialized("tag") ? new QTag(forProperty("tag")) : null;
    }

}

