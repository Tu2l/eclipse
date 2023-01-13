package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.entity.Student;

@SpringBootApplication
public class SringBootLombokDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SringBootLombokDemoApplication.class, args);
		Student student = new Student();
		student.setName("asdsad");
		System.out.println(student.getName());
	}

}
