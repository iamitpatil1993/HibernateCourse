package com.example.hibernate.inheritance.joined;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;
import com.google.gson.Gson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JTSFullTimeEmployeeTest extends BaseTest {

	private static UUID pk = UUID.fromString("19090a58-31e4-40dc-bd07-7cb4d22a6254");

	@Test
	public void aPersistTest() {
		JTSFullTimeEmployee fullTimeEmployee = new JTSFullTimeEmployee();
		fullTimeEmployee.setFirstName("Amit");
		fullTimeEmployee.setLastName("Patil");
		fullTimeEmployee.setStartDate(Calendar.getInstance());
		fullTimeEmployee.setVacation(223l);
		fullTimeEmployee.setPension(5000l);
		fullTimeEmployee.setSalary(10000l);
		em.persist(fullTimeEmployee);
		assertNotNull(fullTimeEmployee.getId());
		pk = fullTimeEmployee.getId();
	}
	
	@Test
	public void bChildMergeTest() {
		JTSFullTimeEmployee fullTimeEmployee = em.find(JTSFullTimeEmployee.class, pk);
		assertNotNull(fullTimeEmployee);
		fullTimeEmployee.setSalary(50000l);
	}
	
	@Test
	public void cChildAndParentMergeTest() {
		JTSFullTimeEmployee fullTimeEmployee = em.find(JTSFullTimeEmployee.class, pk);
		assertNotNull(fullTimeEmployee);
		fullTimeEmployee.setSalary(10000l);
		fullTimeEmployee.setFirstName("Amit Rocks");
	}
	
	@Test
	public void dFindAll() {
		List<JTSFullTimeEmployee> fullTimeEmployees = em.createQuery("SELECT fte FROM JTSFullTimeEmployee fte", JTSFullTimeEmployee.class).getResultList();
		System.out.println(new Gson().toJson(fullTimeEmployees));;
	}
}
