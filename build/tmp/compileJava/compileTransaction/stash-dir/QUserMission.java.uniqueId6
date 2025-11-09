package com.example.umc9th.domain.mission.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMission is a Querydsl query type for UserMission
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMission extends EntityPathBase<UserMission> {

    private static final long serialVersionUID = -432183737L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMission userMission = new QUserMission("userMission");

    public final DateTimePath<java.time.LocalDateTime> completedAt = createDateTime("completedAt", java.time.LocalDateTime.class);

    public final DatePath<java.time.LocalDate> endAt = createDate("endAt", java.time.LocalDate.class);

    public final com.example.umc9th.domain.member.entity.QMember member;

    public final QMission mission;

    public final NumberPath<Integer> progress = createNumber("progress", Integer.class);

    public final EnumPath<UserMission.Status> status = createEnum("status", UserMission.Status.class);

    public QUserMission(String variable) {
        this(UserMission.class, forVariable(variable), INITS);
    }

    public QUserMission(Path<? extends UserMission> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMission(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMission(PathMetadata metadata, PathInits inits) {
        this(UserMission.class, metadata, inits);
    }

    public QUserMission(Class<? extends UserMission> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.example.umc9th.domain.member.entity.QMember(forProperty("member")) : null;
        this.mission = inits.isInitialized("mission") ? new QMission(forProperty("mission"), inits.get("mission")) : null;
    }

}

