package com.example.hibernate.model.identity.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

	private EntityManagerFactory entityManagerFactory;
	protected EntityManager em;
	protected EntityTransaction entityTransaction;

	@Before
	public void beforeTest() {
		entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
		em = entityManagerFactory.createEntityManager();
		entityTransaction = em.getTransaction();
		entityTransaction.begin();
	}

	@After
	public void afterTest() {
		if (entityTransaction.getRollbackOnly()) {
			entityTransaction.rollback();;
			em.close();
		} else {
			entityTransaction.commit();
			em.close();
		}
	}
}
