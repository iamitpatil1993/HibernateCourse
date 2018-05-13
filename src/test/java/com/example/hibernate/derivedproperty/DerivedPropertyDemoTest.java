package com.example.hibernate.derivedproperty;

import java.util.List;

import org.junit.Test;

import com.example.hibernate.model.identity.hibernate.BaseTest;

public class DerivedPropertyDemoTest extends BaseTest {

	@Test
	public void test() {
		DerivedPropertyDemo demo = new DerivedPropertyDemo();
		em.persist(demo);
	}

	@Test
	public void test2() {
		DerivedPropertyDemo demo = em.find(DerivedPropertyDemo.class, 1L);
		System.out.println("derived field before SELECT :: " + demo.getDerivedField());
	}

	@Test
	public void test3() {
		List<DerivedPropertyDemo> results = em
				.createQuery("select d from DerivedPropertyDemo d", DerivedPropertyDemo.class).getResultList();
		results.forEach(demo -> {
			System.out.println("original :: " + demo.getId() + " --->  derived :: " + demo.getDerivedField());

		});
	}
}
