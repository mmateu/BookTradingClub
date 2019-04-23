package com.example.BookTradingClub.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.example.BookTradingClub.service", "com.example.BookTradingClub.common", "com.example.BookTradingClub.presentation"})
@EnableJpaRepositories(basePackages = {"com.example.BookTradingClub.data"})
@EntityScan(basePackages = {"com.example.BookTradingClub.data"})
public class BookTradingClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookTradingClubApplication.class, args);
	}

}
