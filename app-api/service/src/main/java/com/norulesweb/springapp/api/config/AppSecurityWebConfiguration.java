package com.norulesweb.springapp.api.config;

import com.norulesweb.springapp.core.security.AppAuthenticationEntryPoint;
import com.norulesweb.springapp.core.security.AppAuthenticationTokenFilter;
import com.norulesweb.springapp.core.security.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecurityWebConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AppAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private AppUserDetailsService userDetailsService;

	/**
	 * The authentication provider.
	 */
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	/**
	 * The authentication manager
	 */
	@Bean(name="localAuthenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AppAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new AppAuthenticationTokenFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		httpSecurity
//				.exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler).and()
//
//				// don't create session
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
//		httpSecurity.authorizeRequests()
//				.antMatchers("/app-api/user/login").permitAll()
//
//				// By default any request must be authenticated
//				.anyRequest()
//				.authenticated()
//
//				.and().logout().logoutUrl("/app-api/logout").permitAll()
//
//				// Allow HTTP Basic Auth
//				.and().httpBasic().disable();
//
//		httpSecurity.csrf().disable();
//
//		// Custom JWT based security filter
//		httpSecurity
//				.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//
//		// disable page caching
//		httpSecurity.headers().cacheControl();
		http
// defines the authentication for application entrypoints
				.authorizeRequests()
// POST to /rest/oauth/login is not authenticated
				.antMatchers(HttpMethod.POST, "/app-api/user/login").permitAll()
// GET /rest/oauth/token is not authenticated
				.antMatchers(HttpMethod.GET, "/app-api/user/token").permitAll()
// the other REST APIs are authenticated
				.antMatchers("/app-api/**").authenticated()
				.and()
// never use server side sessions (stateless mode)
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.anonymous()
				.and()
				.securityContext()
				.and()
				.headers().disable()
				.rememberMe().disable()
				.requestCache().disable()
				.x509().disable()
				.csrf().disable()
				.httpBasic().disable()
				.formLogin().disable()
				.logout().disable()
// add custom authentication filter
				.addFilterBefore(authenticationTokenFilterBean(), AnonymousAuthenticationFilter.class)
// register custom authentication exception handler
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

}
