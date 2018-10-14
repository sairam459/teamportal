package com.src.teamportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import java.util.Optional;

@SpringBootApplication
@EnableMongoAuditing
public class TeamPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamPortalApplication.class, args);
	}
}
