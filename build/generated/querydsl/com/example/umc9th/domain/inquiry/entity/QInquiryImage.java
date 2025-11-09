package com.example.umc9th.domain.inquiry.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiryImage is a Querydsl query type for InquiryImage
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryImage extends EntityPathBase<InquiryImage> {

    private static final long serialVersionUID = 1061891657L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiryImage inquiryImage = new QInquiryImage("inquiryImage");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QInquiry inquiry;

    public final StringPath photoUrl = createString("photoUrl");

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QInquiryImage(String variable) {
        this(InquiryImage.class, forVariable(variable), INITS);
    }

    public QInquiryImage(Path<? extends InquiryImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiryImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiryImage(PathMetadata metadata, PathInits inits) {
        this(InquiryImage.class, metadata, inits);
    }

    public QInquiryImage(Class<? extends InquiryImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiry = inits.isInitialized("inquiry") ? new QInquiry(forProperty("inquiry"), inits.get("inquiry")) : null;
    }

}

