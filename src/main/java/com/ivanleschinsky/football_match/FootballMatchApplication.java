package com.ivanleschinsky.football_match;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class FootballMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballMatchApplication.class, args);
	}

}
