package com.example.umc9th.domain.food.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;


/**
 * QPreferredFoodTypeId is a Querydsl query type for PreferredFoodTypeId
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPreferredFoodTypeId extends BeanPath<PreferredFoodTypeId> {

    private static final long serialVersionUID = -1610976118L;

    public static final QPreferredFoodTypeId preferredFoodTypeId = new QPreferredFoodTypeId("preferredFoodTypeId");

    public final NumberPath<Long> foodTypeId = createNumber("foodTypeId", Long.class);

    public final StringPath key = createString("key");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QPreferredFoodTypeId(String variable) {
        super(PreferredFoodTypeId.class, forVariable(variable));
    }

    public QPreferredFoodTypeId(Path<? extends PreferredFoodTypeId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPreferredFoodTypeId(PathMetadata metadata) {
        super(PreferredFoodTypeId.class, metadata);
    }

}

