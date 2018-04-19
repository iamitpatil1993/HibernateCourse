package com.example.hibernate.model.identity.hibernate;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NativeStategyTest extends BaseTest {

	@Test
	public void test() {
		NativeStategy nativeStategy = new NativeStategy();
		em.persist(nativeStategy);
		assertNotNull(nativeStategy.getId());
		// Native strategy uses Sequence strategy with Postrgres database
	}

}
