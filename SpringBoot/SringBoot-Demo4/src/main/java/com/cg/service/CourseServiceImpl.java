package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	private List<Course> courseList;

	public CourseServiceImpl() {
		courseList = new ArrayList<>();
		courseList.add(new Course(11, "Java", 50000));
		courseList.add(new Course(77, "C", 50670));
		courseList.add(new Course(54, "C++", 56000));
		courseList.add(new Course(24, "c#", 70000));
		courseList.add(new Course(23, "Spring", 80000));
	}

//	@Override
//	public void addCourse() {
//		Course course = new Course(courseList.size()+1,"course"+courseList.size(),123123);
//		courseList.add(course);
//	}

	@Override
	public List<Course> getAllCourses() {
		return courseList;
	}

	@Override
	public Course findById(int id) {
		Course course = null;
		for (Course c : courseList)
			if (c.getCourseId() == id)
				course = c;

		return course;
	}

	@Override
	public Course deleteById(int id) {
		Course course = null;
		for (int i = 0; i < courseList.size(); i++) {
			if (courseList.get(i).getCourseId() == id) {
				course = courseList.remove(i);
				break;
			}
		}

		return course;
	}

}
