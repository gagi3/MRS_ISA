package com.isamrst17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.isamrst17"})
@EnableJpaRepositories(basePackages="com.isamrst17.repository")
//@EnableAutoConfiguration
@ComponentScan(basePackages = "com.isamrst17")
public class IsamrsT17Application {

	public static void main(String[] args) {
		SpringApplication.run(IsamrsT17Application.class, args);
	}
}
