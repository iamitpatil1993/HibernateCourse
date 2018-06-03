package com.example.hibernate.inheritance.mappedsuperclass;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MappedSuperClassDemoTest extends BaseTest {

	private static UUID pk = null;
	
	@Test
	public void aPersistTest() {
		MappedSuperClassDemo demo = new MappedSuperClassDemo();
		em.persist(demo);
		assertNotNull(demo.getId());
		pk = demo.getId();
	}

	@Test
	public void bFindTest() {
		em.find(MappedSuperClassDemo.class, pk);
	}
	
	@Test
	public void dMergeTest() {
		MappedSuperClassDemo classDemo = new MappedSuperClassDemo();
		classDemo.setFoo("amit");
		classDemo.setId(pk);
		em.merge(classDemo);
	}
}

