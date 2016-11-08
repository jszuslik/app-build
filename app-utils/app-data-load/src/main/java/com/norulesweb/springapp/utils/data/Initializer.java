package com.norulesweb.springapp.utils.data;

import com.norulesweb.springapp.core.model.user.Authority;
import com.norulesweb.springapp.core.model.user.AuthorityName;
import com.norulesweb.springapp.core.repository.user.AuthorityRepository;
import com.norulesweb.springapp.core.services.user.AppUserDTO;
import com.norulesweb.springapp.core.services.user.AuthorityDTO;
import com.norulesweb.springapp.core.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PropertySources({
		                 @PropertySource(value = "classpath:initializer.properties")
		                 , @PropertySource(value = "file:initializer.runtime.properties", ignoreResourceNotFound = true)
})
@Transactional
public class Initializer {

	private static final Logger log = LoggerFactory.getLogger(Initializer.class);

	@Value("${initialize.user.name}")
	protected String userName;

	@Value("${initialize.user.password}")
	protected String userPassword;

	@Value("${initialize.user.firstname}")
	protected String userFirstName;

	@Value("${initialize.user.lastname}")
	protected String userLastName;

	@Value("${initialize.user.email}")
	protected String userEmail;

	@Value("${initialize.user.role.admin}")
	protected String adminRole;

	@Value("${initialize.user.role.user}")
	protected String userRole;

	@Value("${initialize.user.enabled}")
	protected Boolean enabled;

	@Value("${initialize.platform.name}")
	protected String platformName;

	@Value("${initialize.platform.description}")
	protected String platformDescription;

	@Autowired
	protected UserService userService;

	@Autowired
	protected AuthorityRepository authorityRepository;

	public void initializePlatform() {

		log.info("Start Initializing DB");

		initializeAuthorities();

		log.info("End Initializing DB");

	}
	 public void initializeAuthorities(){
		 AppUserDTO appUserDTO = new AppUserDTO();
		 appUserDTO.setUserId(userName);
		 appUserDTO.setPassword(userPassword);
		 appUserDTO.setFirstName(userFirstName);
		 appUserDTO.setLastName(userLastName);
		 appUserDTO.setEmail(userEmail);
		 appUserDTO.setAdmin(true);
		 appUserDTO.setEnabled(enabled);

		 appUserDTO = userService.createAppUser(appUserDTO);

		 AuthorityDTO adminAuth = new AuthorityDTO();
		 adminAuth.setAuthorityName(AuthorityName.ROLE_ADMIN.name());
		 adminAuth.addAppUser(appUserDTO);
		 Authority adAuth = authorityRepository.save(adminAuth.buildModel());

		 AuthorityDTO userAuth = new AuthorityDTO();
		 userAuth.setAuthorityName(AuthorityName.ROLE_USER.name());
		 userAuth.addAppUser(appUserDTO);
		 Authority usAuth = authorityRepository.save(userAuth.buildModel());

		 appUserDTO.addAuthority(new AuthorityDTO(adAuth));
		 appUserDTO.addAuthority(new AuthorityDTO(usAuth));

		 appUserDTO = userService.saveUserChanges(appUserDTO);
	 }

}
