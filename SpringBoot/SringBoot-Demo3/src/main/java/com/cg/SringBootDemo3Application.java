package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * @Configuration
 * @EnableAutoConfiguration
 * @ComponentScanning
 */
@SpringBootApplication
public class SringBootDemo3Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext contex = SpringApplication.run(SringBootDemo3Application.class, args);
	}

}
