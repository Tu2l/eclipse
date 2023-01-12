package com.cg.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Account;
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
	
		Employee emp1 = new Employee(1001,"Emp1","IT",25000,new Account(System.currentTimeMillis(),"SBI",2000.0));
		em.persist(emp1);
//		Employee emp2 = new Employee(1002,"Emp2","IT",28000,new Account(System.currentTimeMillis(),"SBI",2000.0));
//		em.persist(emp2);
//		Employee emp3 = new Employee(1003,"Emp3","Design",35000,new Account(System.currentTimeMillis(),"SBI",2000.0));
//		em.persist(emp3);
//		Employee emp4 = new Employee(1004,"Emp4","Accounts",27000,new Account(System.currentTimeMillis(),"SBI",2000.0));
//		em.persist(emp4);
		
		em.getTransaction().commit();
		
		System.out.print("Added");
	
	}

}
