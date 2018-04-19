package com.example.hibernate.model.identity.hibernate;

import static org.junit.Assert.*;

import org.junit.Test;

public class SequenceIdentityStrategyTest extends BaseTest {

	@Test
	public void test() {
		SequenceIdentityStrategy identityStrategy = new SequenceIdentityStrategy();
		em.persist(identityStrategy);
		assertNotNull(identityStrategy.getId());
	}
}
