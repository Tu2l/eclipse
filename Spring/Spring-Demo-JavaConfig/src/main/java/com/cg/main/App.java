package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.config.Config;
import com.cg.entity.Employee;
import com.cg.entity.Student;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Student s1 = context.getBean(Student.class); 
		s1.setName("Name");
		s1.setRoll(12);
		s1.setCourse("Course");
		
		System.out.println(s1.toString());
		
		Employee emp = context.getBean(Employee.class);
		emp.setEmpId(123);
		emp.setName("Rohit");
		emp.setSalary(50000);
		
		System.out.println(emp.toString());
	}

}
