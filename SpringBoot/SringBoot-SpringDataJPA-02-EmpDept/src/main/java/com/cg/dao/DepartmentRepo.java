package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
