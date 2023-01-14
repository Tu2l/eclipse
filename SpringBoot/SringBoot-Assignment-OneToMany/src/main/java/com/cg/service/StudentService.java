package com.cg.service;

import java.util.List;

import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;

public interface StudentService {
	Student createStudent(Student student);
	
	List<Student> findAllStundent();
	
	Student findStudentById(int id) throws NoSuchStudentFoundException;
	
	Student updateStudent(int id,Student data) throws NoSuchStudentFoundException;
	
	boolean deleteStudent(int id);
	
	List<Student> findStudentsByName(String name);
	
	List<Student> findStundetsByCourseName(String courseName);
	
	Student findByRoll(int roll);
}
