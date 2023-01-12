package com.cg.service;

import java.util.List;

import com.cg.entity.Employee;

public interface EmployeeService {
	void insert(Employee emp);

	void update(Employee emp);

	Employee remove(Employee emp);

	Employee find(int id);

	List<Employee> findAll();
}
