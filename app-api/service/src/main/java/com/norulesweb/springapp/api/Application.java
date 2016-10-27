package com.norulesweb.springapp.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySources({
	@PropertySource(value = "classpath:message_en_USA.properties"),
    @PropertySource(value = "classpath:spring-data-application.properties", ignoreResourceNotFound = true),
    @PropertySource(value = "classpath:spring-data-application.runtime.properties", ignoreResourceNotFound = true)
})
//@ComponentScan(
//		basePackages = { "com.norulesweb.studenttracker.core", "com.norulesweb.studenttracker.api.web", "com.norulesweb.studenttracker.api.security"}
//)
@EnableAutoConfiguration(exclude={
		JmsAutoConfiguration.class
})
@EnableTransactionManagement
// @ImportResource("classpath:spring-application-integration.xml")
//@EnableJpaRepositories(
//		repositoryFactoryBeanClass = AppRepositoryFactoryBean.class,
//		basePackages = { "com.norulesweb.studenttracker.core.repository" }
//)
//@EntityScan(basePackages = { "com.norulesweb.studenttracker.core" })
public class Application extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public FilterRegistrationBean springSecurityFilterChain() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/*");

		return registrationBean;
	}
}
