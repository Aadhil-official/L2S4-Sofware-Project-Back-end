package com.example.SpringMongoPoject;

import org.springframework.boot.SpringApplication;//class this contain run method that pass to main method as application class
import org.springframework.boot.autoconfigure.SpringBootApplication;
//if we don't connect the db then by test the exception will occur if we want stop then we want to comment the dependencies and stop mvn to test that as reload project
//tomcat is web server give a web server and developer server for application
@SpringBootApplication
public class SpringMongoPojectApplication {
//pass command line arguments also
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoPojectApplication.class, args);
	}

}
