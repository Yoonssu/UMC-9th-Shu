package com.example.umc9th.domain.food.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferredFoodType is a Querydsl query type for PreferredFoodType
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferredFoodType extends EntityPathBase<PreferredFoodType> {

    private static final long serialVersionUID = -1360334065L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferredFoodType preferredFoodType = new QPreferredFoodType("preferredFoodType");

    public final QFoodType foodType;

    public final QPreferredFoodTypeId id;

    public final com.example.umc9th.domain.member.entity.QMember member;

    public QPreferredFoodType(String variable) {
        this(PreferredFoodType.class, forVariable(variable), INITS);
    }

    public QPreferredFoodType(Path<? extends PreferredFoodType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferredFoodType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferredFoodType(PathMetadata metadata, PathInits inits) {
        this(PreferredFoodType.class, metadata, inits);
    }

    public QPreferredFoodType(Class<? extends PreferredFoodType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodType = inits.isInitialized("foodType") ? new QFoodType(forProperty("foodType")) : null;
        this.id = inits.isInitialized("id") ? new QPreferredFoodTypeId(forProperty("id")) : null;
        this.member = inits.isInitialized("member") ? new com.example.umc9th.domain.member.entity.QMember(forProperty("member")) : null;
    }

}

