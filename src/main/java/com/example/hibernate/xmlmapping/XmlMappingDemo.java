package com.example.hibernate.xmlmapping;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.hibernate.model.Employee;
import com.example.hibernate.model.Project;

public class XmlMappingDemo {

	public static void main(String[] args) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPADB");
		EntityManager entityManager = managerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Project project = new Project();
		project.setProjectName("Mira");
		entityManager.persist(project);
		
		Employee employee = new Employee();
		employee.setDob(Calendar.getInstance());
		employee.setFirstName("Amit");
		employee.setLastName("Patil");
		employee.setProject(project);
		entityManager.persist(employee);
		
		entityTransaction.rollback();
		entityManager.close();
	}
}
