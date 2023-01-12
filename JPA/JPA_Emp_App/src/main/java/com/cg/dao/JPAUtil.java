package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory EMF;
	private static final EntityManager EM;
	
	static {
		EMF = Persistence.createEntityManagerFactory("JPA-PU");
		EM = EMF.createEntityManager();
	}
	
	private JPAUtil() {}
	
	public EntityTransaction getTransaction() {
		return EM.getTransaction();
	}
	
	public static EntityManager getEM() {
		return EM;
	}
}
