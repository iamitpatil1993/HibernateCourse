package com.example.hibernate.identity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class IdentityDemo {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		for(int i = 1 ; i <= 55 ; i++) {
			com.example.hibernate.model.identity.IdentityDemo demo = new com.example.hibernate.model.identity.IdentityDemo();
			demo.setFoo("amit");
			entityManager.persist(demo);
		}
		entityTransaction.commit();
		entityManager.close();
	}
	
}
