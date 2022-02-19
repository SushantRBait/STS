package com.sushant.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.sushant"})
public class SpringBootRestUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestUserApplication.class, args);
	}

}
