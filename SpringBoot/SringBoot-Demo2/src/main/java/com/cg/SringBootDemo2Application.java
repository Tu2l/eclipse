package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cg.entity.Customer;

//@Configuration
//@ComponentScanning
//@EnableAutoConfiguration

@SpringBootApplication
public class SringBootDemo2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SringBootDemo2Application.class, args);
		Customer customer = context.getBean(Customer.class);
	
		customer.setId(System.currentTimeMillis());
		customer.setName("Tutul");
		customer.getAccount().setId(System.currentTimeMillis());
		customer.getAccount().setAccType("Savings");
		customer.getAccount().setAccBalance(3897.34);
		
		System.out.println(customer);
	}

}
