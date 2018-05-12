package com.example.hibernate.validation;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import com.example.hibernate.model.identity.hibernate.BaseTest;

public class EmployeeBeanValidationDemoTest extends BaseTest {

	private EntityManagerFactory entityManagerFactory;
	protected EntityManager em;
	protected EntityTransaction entityTransaction;

	@Test
	public void validationFailTest() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
			em = entityManagerFactory.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			EmployeeBeanValidationDemo employee = new EmployeeBeanValidationDemo();
			em.persist(employee);

			em.persist(employee);
			entityTransaction.commit();
			em.close();
		} catch (Exception e) {
			assertTrue(e.getCause() instanceof ConstraintViolationException);
			if (e.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException violations = (ConstraintViolationException) e.getCause();
				assertThat(violations.getConstraintViolations(), hasSize(3));
				for (ConstraintViolation<?> violation : violations.getConstraintViolations()) {
					System.out.println(violation);
				}
			}
		}
	}
	
	@Test
	public void validationSuccessTest() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
			em = entityManagerFactory.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			EmployeeBeanValidationDemo employee = new EmployeeBeanValidationDemo();
			employee.setFirstName("Amit");
			employee.setLastName("Patil");
			employee.setDob(Calendar.getInstance());
			em.persist(employee);

			em.persist(employee);
			entityTransaction.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateValidationFailTest() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
			em = entityManagerFactory.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			EmployeeBeanValidationDemo employee = em.find(EmployeeBeanValidationDemo.class, 252l);
			employee.setFirstName(null);
			employee.setLastName(null);

			entityTransaction.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void updateValidationSuccessTest() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("JPADB");
			em = entityManagerFactory.createEntityManager();
			entityTransaction = em.getTransaction();
			entityTransaction.begin();

			EmployeeBeanValidationDemo employee = em.find(EmployeeBeanValidationDemo.class, 252l);
			employee.setFirstName("Updated Amit");
			employee.setLastName("Updated Patil");

			entityTransaction.commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
