package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.Customer;
/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Customer customer = context.getBean("customer", Customer.class);
	
		System.out.println(customer.toString());
		System.out.println(customer.getBankAccount().toString());
	
		
		((ConfigurableApplicationContext)context).close();
	}
}
