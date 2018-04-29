package com.example.hibernate.model.constraint;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;

public class ConstraintViolationDemoTest {

	private EntityManagerFactory entityManagerFactory;
	protected EntityManager em;
	protected EntityTransaction entityTransaction;

	@Test
	public void emailUniqueConstraintViolationTest() {

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
			em = entityManagerFactory.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			ConstraintViolationDemo constraintViolationDemo = new ConstraintViolationDemo();
			constraintViolationDemo.setEmail("iamitpatil1993@gmail.com");

			em.persist(constraintViolationDemo);
			entityTransaction.commit();
			em.close();
		} catch (Exception e) {
			// This is not correct way to handle exceptions, because transaction may get rollbacked due to multiple reasons, ConstraintViolationExcepton
			// is one possibility of transaction failure. So we will have to handle this catch block in more generic way than spcific to  ConstraintViolationExcepton
			Throwable constraintViolationException = e.getCause();
			while((constraintViolationException != null) && !(constraintViolationException instanceof ConstraintViolationException)) {
				constraintViolationException = constraintViolationException
						.getCause();
			}
			if (constraintViolationException instanceof ConstraintViolationException) {
		        // Here you're sure you have a ConstraintViolationException, you can handle it
				System.out.println("exception :: " + constraintViolationException );
				System.out.println("instanceOf :: " + (constraintViolationException instanceof ConstraintViolationException));
				System.out.println("Exception occured");
		    }
		}
	}

}
