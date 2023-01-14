package com.cg.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	@Query("Select s from Student s where s.roll=:roll")
	Student findByRoll(@Param("roll") int roll);
	
	@Query("Select s from Student s where s.name=:name")
	List<Student> findByName(@Param("name") String name);
	
	@Query("Select s from Student s join s.courses c where c.courseName=:name")
	List<Student> findByCourseName(@Param("name") String name);
}
