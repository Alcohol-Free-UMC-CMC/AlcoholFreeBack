package com.example.alcoholfreeback.src.cocktail.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTag is a Querydsl query type for Tag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTag extends EntityPathBase<Tag> {

    private static final long serialVersionUID = 668507249L;

    public static final QTag tag = new QTag("tag");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    public final EnumPath<Tag.Category> category = createEnum("category", Tag.Category.class);

    public final ListPath<CocktailTag, QCocktailTag> cocktails = this.<CocktailTag, QCocktailTag>createList("cocktails", CocktailTag.class, QCocktailTag.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTag(String variable) {
        super(Tag.class, forVariable(variable));
    }

    public QTag(Path<? extends Tag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTag(PathMetadata metadata) {
        super(Tag.class, metadata);
    }

}

