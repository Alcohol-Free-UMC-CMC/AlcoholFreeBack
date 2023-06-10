package com.example.alcoholfreeback.src.tool.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTool is a Querydsl query type for Tool
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTool extends EntityPathBase<Tool> {

    private static final long serialVersionUID = 444411669L;

    public static final QTool tool = new QTool("tool");

    public final com.example.alcoholfreeback.common.entity.QBaseEntity _super = new com.example.alcoholfreeback.common.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final EnumPath<com.example.alcoholfreeback.common.entity.BaseEntity.State> state = _super.state;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTool(String variable) {
        super(Tool.class, forVariable(variable));
    }

    public QTool(Path<? extends Tool> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTool(PathMetadata metadata) {
        super(Tool.class, metadata);
    }

}

