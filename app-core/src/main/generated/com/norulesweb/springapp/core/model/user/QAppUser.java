package com.norulesweb.springapp.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QAppUser is a Querydsl query type for AppUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAppUser extends EntityPathBase<AppUser> {

    private static final long serialVersionUID = -416976448L;

    public static final QAppUser appUser = new QAppUser("appUser");

    public final com.norulesweb.springapp.core.model.common.QModelBase _super = new com.norulesweb.springapp.core.model.common.QModelBase(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath password = createString("password");

    public final StringPath roles = createString("roles");

    public final StringPath userId = createString("userId");

    public QAppUser(String variable) {
        super(AppUser.class, forVariable(variable));
    }

    public QAppUser(Path<? extends AppUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAppUser(PathMetadata<?> metadata) {
        super(AppUser.class, metadata);
    }

}

