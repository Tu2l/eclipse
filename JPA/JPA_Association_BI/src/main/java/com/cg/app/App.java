package com.cg.app;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Department;
import com.cg.entity.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
	
		Employee emp1 = new Employee();
		emp1.setEmpid(100);
		emp1.setName("e1");
		emp1.setSalary(30000);
		
		Employee emp2 = new Employee();
		emp2.setEmpid(101);
		emp2.setName("e2");
		emp2.setSalary(40000);
		
		Department department = new Department();
		department.setId(123);
		department.setName("IT");
		
		emp1.setDepartment(department);
		emp2.setDepartment(department);
		
		Set<Employee> empSet = new LinkedHashSet<>();
		empSet.add(emp1);
		empSet.add(emp2);
		
		department.setEmpList(empSet);
		
		em.persist(department);
		em.getTransaction().commit();
		
		System.out.print("Added");
		
		
		Department findDept = em.find(Department.class, 123);
		findDept.getEmpList().forEach(System.out::println);
		
		em.close();
		emf.close();
	
	}

}
