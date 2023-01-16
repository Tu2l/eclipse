package com.cg.service;

import java.util.List;

import com.cg.entity.Course;
import com.cg.exception.NoSuchCourseFoundException;

public interface CourseService {
	Course createCourse(Course course);
	
	List<Course> findAllCourse();
	
	Course findCourseById(int id) throws NoSuchCourseFoundException;
	
	Course update(int id,Course course) throws NoSuchCourseFoundException;
	
	boolean deleteCourse(int id);
}
