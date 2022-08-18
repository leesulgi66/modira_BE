package com.example.modiraa.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTrade is a Querydsl query type for Trade
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTrade extends EntityPathBase<Trade> {

    private static final long serialVersionUID = -317058148L;

    public static final QTrade trade = new QTrade("trade");

    public final com.example.modiraa.chat.QBaseEntity _super = new com.example.modiraa.chat.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final EnumPath<TradeCategory> category = createEnum("category", TradeCategory.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final NumberPath<Long> createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> like = createNumber("like", Integer.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final EnumPath<TradeStatus> status = createEnum("status", TradeStatus.class);

    public final StringPath title = createString("title");

    public final SetPath<TradeImage, QTradeImage> tradeImages = this.<TradeImage, QTradeImage>createSet("tradeImages", TradeImage.class, QTradeImage.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    //inherited
    public final NumberPath<Long> updatedBy = _super.updatedBy;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Integer> view = createNumber("view", Integer.class);

    public QTrade(String variable) {
        super(Trade.class, forVariable(variable));
    }

    public QTrade(Path<? extends Trade> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTrade(PathMetadata metadata) {
        super(Trade.class, metadata);
    }

}

