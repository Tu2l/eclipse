package com.cg.springmain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.app.Student;

public class App {
	public static void main(String[] args) {	
		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring.xml");
		Student student = appContext.getBean(Student.class);
		student.display();
		
	}
}
