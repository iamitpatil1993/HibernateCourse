package com.example.hibernate.inheritance.joined;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.inheritance.singletablestrategy.CompensationRate;
import com.example.hibernate.inheritance.singletablestrategy.Currency;
import com.example.hibernate.inheritance.singletablestrategy.TimePeriod;
import com.example.hibernate.inheritance.singletablestrategy.TimePeriodType;
import com.example.hibernate.model.identity.hibernate.BaseTest;
import com.google.gson.Gson;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JTSContractEmployeeTest extends BaseTest {

	private static UUID pk = null;

	@Test
	public void aPersistTest() {
		// This persist operation requires insertion into two tables. First for base
		// class and them to actual concrete class with base class foreign key
		// If Inheritance hierarchy is multi-level then it will required (n+1) insert
		// statements where n is level count
		JTSContractEmployee contractEmployee = new JTSContractEmployee();
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
	public void bFindTest() {
		// This uses joint from concrete class to upper level super classes. It it needs one join for each super class. IF we have n levels on hierarchy then
		// joins required are n
		JTSContractEmployee contractEmployee = em.find(JTSContractEmployee.class, pk);
		assertNotNull(contractEmployee);
	}
	
	@Test
	public void cMergeWithOnlySubclassUpdateTest() {
		// Luckily if you have changes in child/subclass entity then, update operation on child entity executes update statment on child entity only and do not
		// include parent entity at all. So this saves us un nessary one update statment on parenet entity.
		JTSContractEmployee contractEmployee = em.find(JTSContractEmployee.class, pk);
		assertNotNull(contractEmployee);
		contractEmployee.setDailyRate(new CompensationRate(800l, Currency.ISR));
		em.merge(contractEmployee);
	}
	
	@Test
	public void dMergeWithChildAndParentAttributeUpdateTest() {
		// This executes two update statements one for parent and one for child
		JTSContractEmployee contractEmployee = em.find(JTSContractEmployee.class, pk);
		assertNotNull(contractEmployee);
		contractEmployee.setFirstName("amit rocks");
		contractEmployee.setDailyRate(new CompensationRate(900l, Currency.ISR));
		em.merge(contractEmployee);
	}
	
	@Test
	public void eFindAll() {
		List<JTSContractEmployee> contractEmployees = em
				.createQuery("SELECT ce FROM JTSContractEmployee ce", JTSContractEmployee.class).getResultList();
		Gson gson = new Gson();
		System.out.println(gson.toJson(contractEmployees));
	}

	@Test
	public void fFindAllWithWhereClasuse() {
		// This polymorphic query on Parent Entity will execute sql wherein, hibernate will left out join all child entity types.
		// And based on join it will create appropriate chile class object in memory.
		List<JTSEmployee> employees = em
				.createQuery("SELECT e FROM JTSEmployee e WHERE e.employeeType = :employeeType",
						JTSEmployee.class)
				.setParameter("employeeType", "JTSContractEmployee").getResultList();
		List<JTSContractEmployee> contractEmployees  = employees.stream().map(emp -> (JTSContractEmployee)emp).collect(Collectors.toList());
		Gson gson = new Gson();
		System.out.println(gson.toJson(contractEmployees));
	}
	
	@Test
	public void gFindAllpolymorphicTest() {
		List<JTSEmployee> employees = em.createQuery("SELECT e FROM JTSEmployee e", JTSEmployee.class).getResultList();
		List<JTSContractEmployee> contractEmployees = new ArrayList<>(employees.size());
		List<JTSFullTimeEmployee> fullTimeEmployees = new ArrayList<>(employees.size());
		employees.stream().forEach(emp -> {
			if (emp instanceof JTSContractEmployee)
				contractEmployees.add((JTSContractEmployee)emp);
			else if (emp instanceof JTSFullTimeEmployee) 
				fullTimeEmployees.add((JTSFullTimeEmployee) emp);
		});
		Gson gson = new Gson();
		System.out.println("Contract Employees :: " + gson.toJson(contractEmployees));
		System.out.println("FullTime Employees :: " + gson.toJson(fullTimeEmployees));
	}
}
