package com.vs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Covid19VaccineSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19VaccineSchedulerApplication.class, args);
	}

}
