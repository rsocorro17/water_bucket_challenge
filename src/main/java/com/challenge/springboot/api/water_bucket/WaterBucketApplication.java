package com.challenge.springboot.api.water_bucket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Spring Boot application for the water bucket challenge.
 * This class initializes the application context and starts the application.
 *
 * @author Ronald Socorro
*/
@SpringBootApplication
public class WaterBucketApplication {

	/**
     * The main method that bootstraps the application.
     * It delegates to Spring Boot's {@link SpringApplication} to start the application.
     *
     * @param args Command-line arguments passed to the application.
	*/
	public static void main(String[] args) {
		SpringApplication.run(WaterBucketApplication.class, args);
	}

}
