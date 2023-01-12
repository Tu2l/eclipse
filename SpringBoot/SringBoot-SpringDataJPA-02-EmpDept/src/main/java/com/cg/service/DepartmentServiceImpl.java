package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.DepartmentRepo;
import com.cg.entity.Department;
import com.cg.exception.NoSuchDepartmentFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;

	@Override
	@Transactional
	public Department addDeparment(Department dept) {
		return deptRepo.save(dept);
	}

	@Override
	public Department getDeptById(int id) throws NoSuchDepartmentFoundException{
		Optional<Department> dept = deptRepo.findById(id);
		if(dept.isPresent())
			return dept.get();
		throw new NoSuchDepartmentFoundException("No dept foud with id: "+id);
	}

	@Override
	public List<Department> getAllDepartment() {
		return deptRepo.findAll();
	}

	@Override
	@Transactional
	public Department updateDepartment(Department newDept, int id) throws NoSuchDepartmentFoundException {
		Department dept = getDeptById(id);
		dept.setName(newDept.getName());
		dept.setEmpList(newDept.getEmpList());
		return deptRepo.save(dept);
	}

	@Override
	@Transactional
	public boolean removeDepartment(int id) {
		deptRepo.deleteById(id);
		Optional<Department> dept = deptRepo.findById(id);
		return !(dept.isPresent());
	
	}

}
