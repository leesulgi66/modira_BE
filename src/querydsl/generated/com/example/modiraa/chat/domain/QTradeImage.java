package com.example.modiraa.chat.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTradeImage is a Querydsl query type for TradeImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTradeImage extends EntityPathBase<TradeImage> {

    private static final long serialVersionUID = -1381660897L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTradeImage tradeImage = new QTradeImage("tradeImage");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final BooleanPath isRepresentative = createBoolean("isRepresentative");

    public final QTrade trade;

    public QTradeImage(String variable) {
        this(TradeImage.class, forVariable(variable), INITS);
    }

    public QTradeImage(Path<? extends TradeImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTradeImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTradeImage(PathMetadata metadata, PathInits inits) {
        this(TradeImage.class, metadata, inits);
    }

    public QTradeImage(Class<? extends TradeImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.trade = inits.isInitialized("trade") ? new QTrade(forProperty("trade")) : null;
    }

}

