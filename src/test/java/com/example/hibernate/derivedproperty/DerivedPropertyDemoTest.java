package com.example.hibernate.derivedproperty;

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
}
