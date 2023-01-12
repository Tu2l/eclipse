package com.cg.app;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Account;
import com.cg.entity.Citizen;
import com.cg.entity.EmailAddress;
import com.cg.entity.Employee;
import com.cg.entity.Passport;
import com.cg.entity.Person;

/**
 * Hello world!
 *
 */
public class App3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Person person = new Person();
		person.setId(123);
		person.setName("Nyanko");
		
		ArrayList<EmailAddress> emails = new ArrayList();
		EmailAddress email1 = new EmailAddress();
		email1.setEmailAddress("email@gmail.com");
		emails.add(email1);
		
		EmailAddress email2 = new EmailAddress();
		email2.setEmailAddress("email@yandex.com");
		emails.add(email2);
		
		EmailAddress email3 = new EmailAddress();
		email3.setEmailAddress("email@yahoo.com");
		emails.add(email3);
		
		person.setMails(emails);
		
		em.persist(person);
		
		em.getTransaction().commit();
		
		System.out.println("Added");
		
		Person findPerson = em.find(Person.class,123);
		System.out.println(findPerson.toString());
	
	}

}
