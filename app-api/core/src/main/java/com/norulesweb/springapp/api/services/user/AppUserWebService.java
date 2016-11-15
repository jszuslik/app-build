package com.norulesweb.springapp.api.services.user;

import com.norulesweb.springapp.core.security.AppAuthenticationRequest;
import com.norulesweb.springapp.core.security.AppTokenUtil;
import com.norulesweb.springapp.core.security.AppUserDetails;
import com.norulesweb.springapp.core.security.AppUserDetailsService;
import com.norulesweb.springapp.core.security.service.AppAuthenticationResponse;
import com.norulesweb.springapp.core.services.user.AppUserDTO;
import com.norulesweb.springapp.core.services.user.UserService;
import com.norulesweb.springapp.core.services.utilities.UserLookup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Service
@Validated
public class AppUserWebService {

	@Autowired
	protected UserService userService;

	@Autowired
	protected UserLookup userLookup;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AppTokenUtil appTokenUtil;

	@Autowired
	private AppUserDetailsService userDetailsService;

	private static final String AUTH_HEADER_NAME = "Authorization";

	public static final String URL_USER_BASE = "/user";

	public static final String URL_USER_LOGIN = URL_USER_BASE + "/login";

	public static final String URL_TOKEN_REFRESH = URL_USER_BASE + "/refresh";

	public static final String URL_USER_LOGUT = URL_USER_BASE + "/logout";

	public static final String URL_USER_REGISTRATION = URL_USER_BASE + "/registration";

	@RequestMapping(value = URL_USER_LOGIN, method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(AppAuthenticationRequest authenticationRequest, Device device, HttpServletResponse response) throws AuthenticationException {
		// Perform the security
		final Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(),
					authenticationRequest.getPassword()
				)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Reload password post-security so we can generate token
		final AppUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = appTokenUtil.generateToken(userDetails, device);

		// Return the token
		return ResponseEntity.ok(new AppAuthenticationResponse(token));
	}

	@RequestMapping(value = URL_TOKEN_REFRESH)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String username = appTokenUtil.getUsernameFromToken(token);
		AppUserDetails user = (AppUserDetails) userDetailsService.loadUserByUsername(username);

		if (appTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
			String refreshedToken = appTokenUtil.refreshToken(token);
			return ResponseEntity.ok(new AppAuthenticationResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

	@RequestMapping(value = URL_USER_REGISTRATION)
	@PreAuthorize("hasRole(ADMIN)")
	@ResponseBody
	public AppUserDTO registerUser(@RequestBody @Valid AppUserDTO appUserDTO) {
		AppUserDTO appUser = userService.createAppUser(appUserDTO);
		if(appUser.getAdmin()) {
			appUser = userService.addAdminAuth(appUser);
			appUser = userService.addUserAuth(appUser);
		} else {
			appUser = userService.addUserAuth(appUser);
		}

		return appUser;
	}

}