package com.cg.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
