package com.cg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("JPA!");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(new Student(100,"Student0"));
		em.persist(new Student(101,"Student1"));
		em.persist(new Student(102,"Student2"));
		em.persist(new Student(103,"Student3"));
		em.persist(new Student(104,"Student4"));
		em.getTransaction().commit();
		
		System.out.println("Student added");
		//find(class,pkey)
		Student s1 = em.find(Student.class, 100);
		System.out.println(s1.toString());
		
		//merge(object)
		
		em.getTransaction().begin();
		s1 = em.find(Student.class, 100);
		s1.setName("Student5");
		em.merge(s1);
		em.getTransaction().commit();
		
		System.out.println("Updated");
		//remove(object)
		em.getTransaction().begin();
		s1 = em.find(Student.class, 104);
		em.remove(s1);
		em.getTransaction().commit();
		System.out.println("Deleted");
		
		
		em.close();
	}
	
	
}
