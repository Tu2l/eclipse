package com.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cg.entity.Employee;
import com.cg.entity.Student;

@Configuration
public class Config {
	
	@Bean
	public Student getStudent() {
		return new Student();
	}
	
	@Bean
	public Employee getEmployee() {
		return new Employee();
	}
	
}
