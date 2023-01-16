package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Course;
import com.cg.exception.NoSuchCourseFoundException;
import com.cg.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;

	@GetMapping("/get/all")
	public ResponseEntity<List<Course>> getAll() {
		try {
			return ResponseEntity.ok(service.findAllCourse());
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<Course> getById(@PathVariable int id) {
		try {
			return ResponseEntity.ok(service.findCourseById(id));
		} catch (NoSuchCourseFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Course> add(@RequestBody Course course) {
		try {
			return new ResponseEntity<>(service.createCourse(course), HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable int id) {
		try {
			return ResponseEntity.accepted().body(service.update(id, course));
		} catch (NoSuchCourseFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		try {
			return new ResponseEntity(service.deleteCourse(id) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
