package com.cg.service;

import com.cg.entity.Employee;
import com.cg.exception.NoSuchEmployeeException;

public interface EmployeeService {
	
	Employee add(Employee emp);
	
	Employee delete(Employee emp);
	
	Employee find(int id)throws NoSuchEmployeeException ;
	
	Employee update(Employee emp);
	
}
