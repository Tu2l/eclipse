package com.cg.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		EmployeeService service = context.getBean(EmployeeServiceImpl.class);
		Employee e1 = context.getBean("e1", Employee.class);
		
		//Employee e2 = new Employee(123,"Tutul",30000);

		service.insert(e1);
		
		System.out.println(service.findAll());
	}
}
