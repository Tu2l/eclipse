package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.StudenRepository;
import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudenRepository repository;

	@Override
	@Transactional
	public Student createStudent(Student student) {
		if (student.getId() > 0)
			return repository.save(student);

		return null;
	}

	@Override
	public List<Student> findAllStudents() {
		return repository.findAll();
	}

	@Override
	public Student findStudentById(int id) throws NoSuchStudentFoundException {
		Optional<Student> student = repository.findById(id);
		if (student.isPresent())
			return student.get();

		throw new NoSuchStudentFoundException("No student found with the id: " + id);
	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student update) throws NoSuchStudentFoundException {
		deleteStudent(id);
		return repository.save(update);
	}

	@Override
	@Transactional
	public Student deleteStudent(int id) throws NoSuchStudentFoundException {
		Student student = findStudentById(id);
		repository.deleteById(id);
		return student;
	}

	@Override
	public List<Student> findStudentByMarks(float marks) {
		return repository.findStudentByMarks(marks);
	}

	@Override
	public List<Student> findStudentByName(String name) {
		return repository.findStudentByName(name);
	}

	@Override
	public List<Student> findStudetsOrderByMarks() {
		return repository.findStudentsOrderByMarks();
	}

}
