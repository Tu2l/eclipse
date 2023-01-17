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

import com.cg.dto.StudentDTO;
import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;
import com.cg.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/get/all")
	public ResponseEntity<List<StudentDTO>> getAll() {
		List<StudentDTO> students = modelMapper.map(service.findAllStundent(), new TypeToken<List<StudentDTO>>() {
		}.getType());
		return ResponseEntity.ok(students);
	}

	@GetMapping("/get/byid/{id}")
	public ResponseEntity<StudentDTO> getById(@PathVariable int id) throws NoSuchStudentFoundException {
		return ResponseEntity.ok(modelMapper.map(service.findStudentById(id), StudentDTO.class));

	}

	@GetMapping("/get/byroll/{roll}")
	public ResponseEntity<StudentDTO> getByRoll(@PathVariable int roll) {
		return ResponseEntity.ok(modelMapper.map(service.findByRoll(roll), StudentDTO.class));
	}

	@GetMapping("/get/byname/{sname}")
	public ResponseEntity<List<StudentDTO>> getByName(@PathVariable String sname) {
		List<StudentDTO> students = modelMapper.map(service.findStudentsByName(sname),
				new TypeToken<List<StudentDTO>>() {
				}.getType());
		return ResponseEntity.ok(students);
	}

	@GetMapping("/get/bycoursename/{cname}")
	public ResponseEntity<List<StudentDTO>> getByCourseName(@PathVariable String cname) {
		List<StudentDTO> students = modelMapper.map(service.findStundetsByCourseName(cname),
				new TypeToken<List<StudentDTO>>() {
				}.getType());
		return ResponseEntity.ok(students);
	}

	@PostMapping("/add")
	public ResponseEntity<StudentDTO> add(@Valid @RequestBody StudentDTO studentDto) {
		Student student = modelMapper.map(studentDto, Student.class);
		studentDto = modelMapper.map(service.createStudent(student), StudentDTO.class);
		return new ResponseEntity<>(studentDto, HttpStatus.CREATED);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO studentDto, @PathVariable int id)
			throws NoSuchStudentFoundException {
		Student student = modelMapper.map(studentDto, Student.class);
		studentDto = modelMapper.map(service.updateStudent(id, student), StudentDTO.class);
		return ResponseEntity.accepted().body(studentDto);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		return new ResponseEntity<>(service.deleteStudent(id) ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED);
	}
}
