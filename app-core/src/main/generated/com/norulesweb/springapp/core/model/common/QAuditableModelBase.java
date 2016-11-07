package com.norulesweb.springapp.core.model.common;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAuditableModelBase is a Querydsl query type for AuditableModelBase
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QAuditableModelBase extends EntityPathBase<AuditableModelBase> {

    private static final long serialVersionUID = -1209018287L;

    public static final QAuditableModelBase auditableModelBase = new QAuditableModelBase("auditableModelBase");

    public final QModelBase _super = new QModelBase(this);

    public final DateTimePath<java.time.Instant> createdOn = createDateTime("createdOn", java.time.Instant.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.Instant> updatedOn = createDateTime("updatedOn", java.time.Instant.class);

    public QAuditableModelBase(String variable) {
        super(AuditableModelBase.class, forVariable(variable));
    }

    public QAuditableModelBase(Path<? extends AuditableModelBase> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAuditableModelBase(PathMetadata<?> metadata) {
        super(AuditableModelBase.class, metadata);
    }

}

