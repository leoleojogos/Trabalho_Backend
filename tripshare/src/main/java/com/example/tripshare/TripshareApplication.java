package com.example.tripshare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.tripshare.config.DatabaseInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TripshareApplication {

	public static void main(String[] args) {
		DatabaseInitializer.createDatabaseIfNotExists();
		
		SpringApplication app = new SpringApplication(TripshareApplication.class);
		app.addInitializers(new DatabaseInitializer());
		app.run(args);
	}

}

