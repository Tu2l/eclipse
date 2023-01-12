package com.cg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Author;

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
		Author author1 = new Author("ABC","Tutul","Deb","Roy","9854851059"); 
		em.persist(author1);
		Author author2 = new Author("EFG","Rohit","","Sharma","9854851059");
		em.persist(author2);
		Author author3 = new Author("XYZ","A","B","C","9854851059");
		em.persist(author3);
		Author author4 = new Author("PQL","Z","Y","Z","9854851059");
		em.persist(author4);
		em.getTransaction().commit();
		
		System.out.println("Student added");
		//find(class,pkey)
		Author a1 = em.find(Author.class, "ABC");
		System.out.println(a1.toString());
	
		//merge(object)
		
		em.getTransaction().begin();
		a1 = em.find(Author.class, "EFG");
		a1.setFirstName("qwerty");
		em.merge(a1);
		em.getTransaction().commit();
		
		System.out.println("Updated");
		//remove(object)
		em.getTransaction().begin();
		a1 = em.find(Author.class, "PQL");
		em.remove(a1);
		em.getTransaction().commit();
		System.out.println("Deleted");
		
		
		em.close();
	}
	
	
}
