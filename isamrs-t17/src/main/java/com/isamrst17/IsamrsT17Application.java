package com.isamrst17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.isamrst17.repository")
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.isamrst17")
public class IsamrsT17Application {

	public static void main(String[] args) {
		SpringApplication.run(IsamrsT17Application.class, args);
	}
}
