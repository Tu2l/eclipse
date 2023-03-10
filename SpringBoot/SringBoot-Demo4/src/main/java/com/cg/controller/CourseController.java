package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Course;
import com.cg.service.CourseServiceImpl;

@RestController
public class CourseController {

	@Autowired
	private CourseServiceImpl service;

	@RequestMapping(path = "/allcourses")
	public List<Course> getCourses() {
		return service.getAllCourses();
	}

	// http://localhost:8080/findcourse/11
	@RequestMapping(path = "/findcourse/{cid}")
	public Course findCourse(@PathVariable int cid) {
		return service.findById(cid);
	}

	// http://localhost:8080/deletecourse/11
	@RequestMapping(path = "/deletecourse/{cid}")
	public Course deleteCourse(@PathVariable int cid) {
		return service.deleteById(cid);
	}
}
