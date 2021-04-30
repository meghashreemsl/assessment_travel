package com.wolken.wolkenapp.demoTravelTour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoTravelTourApplication {
	private static final Logger logger=LoggerFactory.getLogger(DemoTravelTourApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoTravelTourApplication.class, args);
		logger.info("main");
	}

}
