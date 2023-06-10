package com.example.alcoholfreeback.src.cocktail.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIngredientCocktail is a Querydsl query type for IngredientCocktail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIngredientCocktail extends EntityPathBase<IngredientCocktail> {

    private static final long serialVersionUID = 1861437278L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIngredientCocktail ingredientCocktail = new QIngredientCocktail("ingredientCocktail");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    public final StringPath amount = createString("amount");

    public final QCocktail cocktail;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QIngredient ingredient;

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QIngredientCocktail(String variable) {
        this(IngredientCocktail.class, forVariable(variable), INITS);
    }

    public QIngredientCocktail(Path<? extends IngredientCocktail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIngredientCocktail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIngredientCocktail(PathMetadata metadata, PathInits inits) {
        this(IngredientCocktail.class, metadata, inits);
    }

    public QIngredientCocktail(Class<? extends IngredientCocktail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cocktail = inits.isInitialized("cocktail") ? new QCocktail(forProperty("cocktail")) : null;
        this.ingredient = inits.isInitialized("ingredient") ? new QIngredient(forProperty("ingredient")) : null;
    }

}

