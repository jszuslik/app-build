package com.norulesweb.springapp.core.model.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QModelBase is a Querydsl query type for ModelBase
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QModelBase extends EntityPathBase<ModelBase> {

    private static final long serialVersionUID = -2055827154L;

    public static final QModelBase modelBase = new QModelBase("modelBase");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QModelBase(String variable) {
        super(ModelBase.class, forVariable(variable));
    }

    public QModelBase(Path<? extends ModelBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QModelBase(PathMetadata<?> metadata) {
        super(ModelBase.class, metadata);
    }

}

