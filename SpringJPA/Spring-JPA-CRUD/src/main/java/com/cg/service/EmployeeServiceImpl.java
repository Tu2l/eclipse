package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dao.EmployeeDAO;
import com.cg.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@Override
	public void insert(Employee emp) {
		employeeDao.insert(emp);
	}

	@Override
	public void update(Employee emp) {
		employeeDao.update(emp);
	}

	@Override
	public Employee remove(Employee emp) {
		return employeeDao.remove(emp);
	}

	@Override
	public Employee find(int id) {
		return employeeDao.find(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
}
