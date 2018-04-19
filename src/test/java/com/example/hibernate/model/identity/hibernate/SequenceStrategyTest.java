package com.example.hibernate.model.identity.hibernate;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SequenceStrategyTest extends BaseTest {

	@Test
	public void test() {
		SequenceStrategy sequenceStrategy = new SequenceStrategy();
		em.persist(sequenceStrategy);
		assertNotNull(sequenceStrategy.getId());
	}
}
