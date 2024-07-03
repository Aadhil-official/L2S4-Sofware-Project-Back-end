package com.example.Software.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class SoftwareProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftwareProjectApplication.class, args);
	}

}
