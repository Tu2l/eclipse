package com.cg.service;

import java.util.List;

import com.cg.entity.Course;

public interface CourseService {
//	void addCourse();

	List<Course> getAllCourses();
	
	Course findById(int id);
	
	Course deleteById(int id);
	
}
