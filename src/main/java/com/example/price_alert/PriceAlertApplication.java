package com.example.price_alert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PriceAlertApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceAlertApplication.class, args);
	}

}
