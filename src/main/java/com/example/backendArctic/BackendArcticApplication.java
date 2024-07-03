package com.example.backendArctic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableMongoRepositories
@SpringBootApplication
@EnableScheduling
public class BackendArcticApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendArcticApplication.class, args);
	}

}
