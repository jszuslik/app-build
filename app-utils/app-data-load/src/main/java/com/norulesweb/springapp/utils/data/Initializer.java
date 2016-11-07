package com.norulesweb.springapp.utils.data;

import com.norulesweb.springapp.core.model.user.AppUser;
import com.norulesweb.springapp.core.repository.user.AppUserRepository;
import com.norulesweb.springapp.core.utilities.user.AppUserUtilities;
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

	@Value("${initialize.user.email}")
	protected String userEmail;

	@Value("${initialize.user.roles}")
	protected String roles;

	@Value("${initialize.platform.name}")
	protected String platformName;

	@Value("${initialize.platform.description}")
	protected String platformDescription;

	@Autowired
	protected AppUserRepository appUserRepository;

	@Autowired
	protected AppUserUtilities appUtilities;


	public void initializePlatform() {

		log.info("Start Initializing DB");

		String encodedPassword = appUtilities.encodePassword(userPassword);

		AppUser appUser = new AppUser(userName, encodedPassword, roles);
		appUserRepository.save(appUser);


		log.info("End Initializing DB");

	}
}
