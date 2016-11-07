package com.norulesweb.springapp.utils.data;

import com.norulesweb.springapp.utils.config.CommandLineUtilityConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This sets up the database tables for the simulator
 */
@Configuration
@ComponentScan(basePackageClasses = {Initializer.class})
public class DataLoaderApplication extends CommandLineUtilityConfiguration {

	private static final Logger log = LoggerFactory.getLogger(DataLoaderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DataLoaderApplication.class, args);
	}

	@Autowired
	protected Initializer initializer;

	@Bean
	public CommandLineRunner demo()
	{
		return (args) -> {

			log.info("Initializing platform");
			initializer.initializePlatform();


			// initializer.setup();

			System.exit(0);
		};
	}

}
