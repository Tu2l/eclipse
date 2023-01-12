package com.cg.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Student;

@Repository
public interface StudenRepository extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.marks =:marks")
	List<Student> findStudentByMarks(@Param("marks") float marks);

	@Query("SELECT s FROM Student s WHERE s.name =:name")
	List<Student> findStudentByName(@Param("name") String name);

	@Query(nativeQuery = true, value = "SELECT * From students_springboot order by marks DESC")
	List<Student> findStudentsOrderByMarks();

}
