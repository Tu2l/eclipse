package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Employee emp) {
		em.persist(emp);
	}

	@Override
	@Transactional
	public void update(Employee emp) {
		em.merge(emp);	
	}

	@Override
	@Transactional
	public Employee remove(Employee emp) {
		em.remove(emp);
		return emp;
	}

	@Override
	public Employee find(int id) {
		return em.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = em.createQuery("SELECT e FROM Employee e",Employee.class);
		return query.getResultList();
	}
}
