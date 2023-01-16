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

import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;
import com.cg.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@GetMapping("/get/all")
	public ResponseEntity<List<Student>> getAll() {
		try {
			return ResponseEntity.ok(service.findAllStundent());
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<Student> getById(@PathVariable int id) {
		try {
			return ResponseEntity.ok(service.findStudentById(id));
		} catch (NoSuchStudentFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get/byroll/{roll}")
	public ResponseEntity<Student> getByRoll(@PathVariable int roll) {
		try {
			return ResponseEntity.ok(service.findByRoll(roll));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get/byname/{sname}")
	public ResponseEntity<List<Student>> getByName(@PathVariable String sname) {
		try {
			return ResponseEntity.ok(service.findStudentsByName(sname));
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/get/bycoursename/{cname}")
	public ResponseEntity<List<Student>> getByCourseName(@PathVariable String cname) {
		try {
			return ResponseEntity.ok(service.findStundetsByCourseName(cname));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/add")
	public ResponseEntity<Student> add(@RequestBody Student student) {
		try {
			return new ResponseEntity<>(service.createStudent(student), HttpStatus.CREATED);
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int id) {
		try {
			return ResponseEntity.accepted().body(service.updateStudent(id, student));
		} catch (NoSuchStudentFoundException ex) {
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		try {
			return new ResponseEntity(service.deleteStudent(id)? HttpStatus.ACCEPTED:HttpStatus.NOT_MODIFIED);
		}  catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
