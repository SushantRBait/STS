package com.sushant.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication   //(scanBasePackages = {"com.sushant.main"} )
public class CustomerSimRecordsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSimRecordsApplication.class, args);
	}

}
