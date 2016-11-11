package com.norulesweb.springapp.core.services.utilities;

import com.norulesweb.springapp.core.security.AppUserDetails;

public interface UserLookup {
	AppUserDetails getCurrentUser();
}
