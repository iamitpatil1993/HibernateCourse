package com.example.hibernate.access.override.newmethod;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.hibernate.model.identity.hibernate.BaseTest;

public class AccessOverrideDemoTest extends BaseTest {

	@Test
	public void test() {
		AccessOverrideDemo accessOverrideDemo = new AccessOverrideDemo();
		accessOverrideDemo.setName("amit");
		em.persist(accessOverrideDemo);		
		assertEquals("amitfoo", accessOverrideDemo.getName());
	}
}
