package com.example.hibernate.inheritance.singletablestrategy;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;
import com.google.gson.Gson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class STSContractEmployeeTest extends BaseTest {

	private static UUID pk = null;

	@Test
	public void aPersistTest() {
		STSContractEmployee contractEmployee = new STSContractEmployee();
		contractEmployee.setDailyRate(new CompensationRate(500l, Currency.ISR));
		contractEmployee.setTerm(new TimePeriod(20, TimePeriodType.DAY));
		contractEmployee.setFirstName("Amit");
		contractEmployee.setLastName("Patil");
		contractEmployee.setStartDate(Calendar.getInstance());
		em.persist(contractEmployee);
		assertNotNull(contractEmployee.getId());

		pk = contractEmployee.getId();
	}

	@Test
	public void bMergeTest() {
		STSContractEmployee contractEmployee = em.find(STSContractEmployee.class, pk);
		assertNotNull(contractEmployee);
		contractEmployee.setDailyRate(new CompensationRate(550l, Currency.ISR));
		em.merge(contractEmployee);
	}

	@Test
	public void cFindAll() {
		List<STSContractEmployee> contractEmployees = em
				.createQuery("SELECT ce FROM STSContractEmployee ce", STSContractEmployee.class).getResultList();
		Gson gson = new Gson();
		System.out.println(gson.toJson(contractEmployees));
	}

	@Test
	public void cFindAllWithWhereClasuse() {
		List<STSEmployee> employees = em
				.createQuery("SELECT e FROM STSEmployee e WHERE e.employeeType = :employeeType",
						STSEmployee.class)
				.setParameter("employeeType", "STSContractEmployee").getResultList();
		List<STSContractEmployee> contractEmployees  = employees.stream().map(emp -> (STSContractEmployee)emp).collect(Collectors.toList());
		Gson gson = new Gson();
		System.out.println(gson.toJson(contractEmployees));
	}
	
	@Test
	public void dEmployeeFindTest() {
		STSEmployee employee = em.find(STSEmployee.class, pk);
		assertNotNull(employee);
	}
}
