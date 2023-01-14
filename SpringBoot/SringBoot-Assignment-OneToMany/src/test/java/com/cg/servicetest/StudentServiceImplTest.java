package com.cg.servicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.dao.StudentRepo;
import com.cg.entity.Course;
import com.cg.entity.Student;
import com.cg.exception.NoSuchStudentFoundException;
import com.cg.service.StudentServiceImpl;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
	@Mock
	private StudentRepo sRepo;

	@InjectMocks
	private StudentServiceImpl service;

	// mock list of students
	private List<Student> students;
	private Student student;
	private Course course;

	@BeforeEach
	void setUp() throws Exception {
		course = new Course();
		course.setCourseId(102);
		course.setCourseName("CCC");
		course.setCourseFees(1000);

		student = new Student();
		student.setId(10);
		student.setRoll(123);
		student.setName("ABC");
		student.getCourses().add(course);

		students = new ArrayList<>();
		students.add(student);
	}

	@Test
	void testCreateStudent() {
		when(service.createStudent(student)).thenReturn(student);
		assertEquals(student,service.createStudent(student));
	}

	@Test
	void testFindAllStundent() {
		when(service.findAllStundent()).thenReturn(students);
		assertEquals(students,service.findAllStundent());
	}

	@Test
	void testFindStudentById() {
		try {
			when(sRepo.findById(10)).thenReturn(Optional.of(student)).then(i -> service.findStudentById(10));
			assertEquals(student, service.findStudentById(10));
		} catch (NoSuchStudentFoundException e) {
			fail("Exception not expected");
		}
	}

	@Test
	void testFindStudentByIdException() {
		// when(sRepo.findById(0)).then(i -> service.findStudentById(10));

		NoSuchStudentFoundException exception = assertThrows(NoSuchStudentFoundException.class,
				() -> service.findStudentById(0));

		assertEquals("Invalid student id", exception.getMessage());

	}

	@Test
	void testUpdateStudent() {
		student.setName("new name");
		student.setRoll(213);
		try {
			when(sRepo.findById(10)).thenReturn(Optional.of(student));
			when(service.updateStudent(10, student)).thenReturn(student);
			//System.out.println(service.updateStudent(10, student));
			assertEquals(student, service.updateStudent(10, student));
		} catch (NoSuchStudentFoundException e) {
			e.printStackTrace();
			fail("Exception not expected");
		}
	}

	@Test
	void testDeleteStudent() {
		students.clear();
		
		Mockito.when(sRepo.findById(10)).thenReturn(Optional.of(student)).then(i -> service.deleteStudent(10));
		assertTrue(service.deleteStudent(10));
		
		when(service.findAllStundent()).thenReturn(students);
		assertEquals(students,service.findAllStundent());
	}

	@Test
	void testFindStudentsByName() {
		when(sRepo.findByName("ABC")).thenReturn(students).then(i -> service.findStudentsByName("ABC"));
		assertEquals(students, service.findStudentsByName("ABC"));
		
	}

	@Test
	void testFindStundetsByCourseName() {
		when(sRepo.findByCourseName("CCC")).thenReturn(students).then(i -> service.findStundetsByCourseName("CCC"));
		assertEquals(students, service.findStundetsByCourseName("CCC"));
	}

	@Test
	void testFindByRoll() {
		when(sRepo.findByRoll(123)).thenReturn(student).then(i -> service.findByRoll(123));
		assertEquals(student, service.findByRoll(123));
	}

}
