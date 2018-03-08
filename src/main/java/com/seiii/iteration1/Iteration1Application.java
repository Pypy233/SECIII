package com.seiii.iteration1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Iteration1Application {

	public static void main(String[] args) {
		SpringApplication.run(Iteration1Application.class, args);
	}
}
