package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.StudentRepo;
import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo sSepo;

	@Override
	@Transactional
	public Student createStudent(Student student) {
		return sSepo.save(student);
	}

	@Override
	public List<Student> findAllStundent() {
		return sSepo.findAll();
	}

	@Override
	public Student findStudentById(int id) throws NoSuchStudentFoundException {
		return sSepo.findById(id).orElseThrow(() -> new NoSuchStudentFoundException("Invalid student id"));
	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student data) throws NoSuchStudentFoundException {
		Student student = findStudentById(id);
		student.setRoll(student.getRoll());
		student.setName(data.getName());
		student.setCourses(data.getCourses());
		return sSepo.save(student);
	}

	@Override
	@Transactional
	public boolean deleteStudent(int id) {
		sSepo.deleteById(id);
		Optional<Student> find = sSepo.findById(id);
		return !(find.isEmpty());
	}

	@Override
	public List<Student> findStudentsByName(String name) {
		return sSepo.findByName(name);
	}

	@Override
	public List<Student> findStundetsByCourseName(String courseName) {
		return sSepo.findByCourseName(courseName);
	}

	@Override
	public Student findByRoll(int roll) {
		return sSepo.findByRoll(roll);
	}

}
