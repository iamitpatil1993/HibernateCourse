package com.example.hibernate.model.identity.hibernate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EnhanceSequenceStrategyTest extends BaseTest {

	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			EnhanceSequenceStrategy enhanceSequenceStrategy = new EnhanceSequenceStrategy();
			em.persist(enhanceSequenceStrategy);
			assertNotNull(enhanceSequenceStrategy.getId());
		}
	}
}
