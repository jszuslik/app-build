package com.norulesweb.springapp.api.services.user;

import com.norulesweb.springapp.core.services.user.AppUserDTO;
import com.norulesweb.springapp.core.services.user.UserService;
import com.norulesweb.springapp.core.services.utilities.UserLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Service
@Validated
public class AppUserWebService {

	@Autowired
	protected UserService userService;

	@Autowired
	protected UserLookup userLookup;

	public static final String URL_USER_BASE = "/user";

	public static final String URL_USER_LOGIN = URL_USER_BASE + "/login";

	public static final String URL_USER_LOGUT = URL_USER_BASE + "/logout";

	public static final String URL_USER_REGISTRATION = URL_USER_BASE + "/registration";

	@RequestMapping(value = URL_USER_REGISTRATION)
	@ResponseBody
	public ResponseEntity<?> registerUser(HttpHeaders httpHeaders, @RequestBody @Valid AppUserDTO appUserDTO) {
		AppUserDTO appUser = userService.createAppUser(appUserDTO.getUserId(),appUserDTO.getPassword());

		return ResponseEntity.ok(appUser);
	}

}
