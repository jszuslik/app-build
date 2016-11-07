package com.norulesweb.springapp.core.model.user;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QAppUser is a Querydsl query type for AppUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAppUser extends EntityPathBase<AppUser> {

    private static final long serialVersionUID = -416976448L;

    public static final QAppUser appUser = new QAppUser("appUser");

    public final com.norulesweb.springapp.core.model.common.QModelBase _super = new com.norulesweb.springapp.core.model.common.QModelBase(this);

    public final ListPath<Authority, QAuthority> authorities = this.<Authority, QAuthority>createList("authorities", Authority.class, QAuthority.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final BooleanPath enabled = createBoolean("enabled");

    public final StringPath firstName = createString("firstName");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath lastName = createString("lastName");

    public final DateTimePath<java.util.Date> lastPasswordResetDate = createDateTime("lastPasswordResetDate", java.util.Date.class);

    public final StringPath password = createString("password");

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

