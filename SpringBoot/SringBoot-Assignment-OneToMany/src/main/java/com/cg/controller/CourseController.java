package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

import com.cg.dto.CourseDTO;
import com.cg.entity.Course;
import com.cg.exception.NoSuchCourseFoundException;
import com.cg.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService service;
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/get/all")
	public ResponseEntity<List<CourseDTO>> getAll() {
		List<CourseDTO> courses = modelMapper.map(service.findAllCourse(), new TypeToken<List<CourseDTO>>() {
		}.getType());
		return ResponseEntity.ok(courses);
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<CourseDTO> getById(@PathVariable int id) throws NoSuchCourseFoundException {
		return ResponseEntity.ok(modelMapper.map(service.findCourseById(id), CourseDTO.class));

	}

	@PostMapping("/add")
	public ResponseEntity<CourseDTO> add(@Valid @RequestBody CourseDTO courseDto) {
		Course course = modelMapper.map(courseDto, Course.class);
		return new ResponseEntity<>(modelMapper.map(service.createCourse(course), CourseDTO.class), HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO courseDto, @PathVariable int id)
			throws NoSuchCourseFoundException {
		Course course = modelMapper.map(courseDto, Course.class);
		return ResponseEntity.accepted().body(modelMapper.map(service.update(id, course), CourseDTO.class));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteCourse(id) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED);
	}
}
