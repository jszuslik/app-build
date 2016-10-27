package com.norulesweb.springapp.core.services.utilities;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.security.AppUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserLookupImpl implements UserLookup {

	@Override
	public AppUser getCurrentUser() {
		AppUser returnUser = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			AppUserDetails userDetails = (AppUserDetails) auth.getPrincipal();
			if(userDetails != null){
				returnUser = userDetails.getAppUser();
			}
		}
		return returnUser;
	}
}
