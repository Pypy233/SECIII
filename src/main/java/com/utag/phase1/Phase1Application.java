package com.utag.phase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Phase1Application {

	public static void main(String[] args) {
		SpringApplication.run(Phase1Application.class, args);
	}
}
