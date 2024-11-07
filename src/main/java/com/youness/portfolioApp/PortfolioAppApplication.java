package com.youness.portfolioApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.youness.portfolioApp"}) // Make sure the mapper package is included
public class PortfolioAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioAppApplication.class, args);
	}

}
