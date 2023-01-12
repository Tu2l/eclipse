package com.cg.dao;

import com.cg.entity.Employee;

public interface EmployeeDAO {
	
	Employee add(Employee emp);
	
	Employee delete(Employee emp);
	
	Employee find(int id);
	
	Employee update(Employee emp);
	
}
