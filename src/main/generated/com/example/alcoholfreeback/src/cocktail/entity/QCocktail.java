package com.example.alcoholfreeback.src.cocktail.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCocktail is a Querydsl query type for Cocktail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCocktail extends EntityPathBase<Cocktail> {

    private static final long serialVersionUID = -236557907L;

    public static final QCocktail cocktail = new QCocktail("cocktail");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final ListPath<IngredientCocktail, QIngredientCocktail> ingredients = this.<IngredientCocktail, QIngredientCocktail>createList("ingredients", IngredientCocktail.class, QIngredientCocktail.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath recipe = createString("recipe");

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    public final ListPath<CocktailTag, QCocktailTag> tags = this.<CocktailTag, QCocktailTag>createList("tags", CocktailTag.class, QCocktailTag.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> views = createNumber("views", Long.class);

    public QCocktail(String variable) {
        super(Cocktail.class, forVariable(variable));
    }

    public QCocktail(Path<? extends Cocktail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCocktail(PathMetadata metadata) {
        super(Cocktail.class, metadata);
    }

}

