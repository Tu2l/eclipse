package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.Customer;
import com.cg.app.Customer2;

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
		
		Customer2 customer2 = context.getBean("customer2", Customer2.class);
		
		System.out.println(customer2.toString());
		System.out.println(customer2.getBankAccount().toString());
	
		
		((ConfigurableApplicationContext)context).close();
	}
}
