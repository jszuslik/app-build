package com.norulesweb.springapp.api.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebMvcInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppSecurityWebConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletMappings() {
		return new Class[] { AppSecurityWebConfiguration.class };
	}
}
