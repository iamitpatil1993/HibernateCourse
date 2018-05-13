package com.example.hibernate.access.property;

import org.junit.Test;

import com.example.hibernate.model.identity.hibernate.BaseTest;

public class PropertyAccessDemoTest extends BaseTest {

	@Test
	public void test() {
		PropertyAccessDemo accessDemo = new PropertyAccessDemo();
		em.persist(accessDemo);
	}
}
