package com.example.hibernate;


import java.util.List;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.hamcrest.Matchers.*;
import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColumnTransformerDemoTest extends BaseTest {

	private static Long pk = null;

	@Test
	public void apersistTest() {
		System.out.println("------------------------------------- apersistTest---------------------------------------------");
		ColumnTransformerDemo columnTransformerDemo = new ColumnTransformerDemo();
		columnTransformerDemo.setWeightInPound(149.9);
		em.persist(columnTransformerDemo);
		pk = columnTransformerDemo.getId();
	}

	@Test
	public void bentityManagerReadTest() {
		System.out.println("------------------------------------- bentityManagerReadTest---------------------------------------------");
		ColumnTransformerDemo demo = em.find(ColumnTransformerDemo.class, pk);
		assertEquals(149, demo.getWeightInPound().longValue());
	}

	@Test
	public void jpaEntitySelectTest() {
		System.out.println("------------------------------------- jpaEntitySelectTest---------------------------------------------");
		ColumnTransformerDemo columnTransformerDemo = em
				.createQuery("SELECT demo FROM ColumnTransformerDemo demo WHERE id = :id", ColumnTransformerDemo.class)
				.setParameter("id", pk).getSingleResult();
		System.out.println("weight in pound :: " + columnTransformerDemo.getWeightInPound());
		assertEquals(149, columnTransformerDemo.getWeightInPound().longValue());
	}
	
	@Test
	public void jpaColumnSelectTest() {
		System.out.println("------------------------------------- jpaColumnSelectTest---------------------------------------------");
		Double weightInPound = em
				.createQuery("SELECT demo.weightInPound FROM ColumnTransformerDemo demo WHERE id = :id", Double.class)
				.setParameter("id", pk).getSingleResult();
		System.out.println("weight in pound :: " + weightInPound);
		assertEquals(149, weightInPound.longValue());
	}
	
	@Test
	public void jpaEntityFilterTest() {
		System.out.println("------------------------------------- jpaEntityFilterTest---------------------------------------------");
		List<ColumnTransformerDemo> columnTransformerDemos = em
				.createQuery("SELECT demo FROM ColumnTransformerDemo demo WHERE demo.weightInPound > :weight", ColumnTransformerDemo.class)
				.setParameter("weight", 148d).getResultList();
		System.out.println("count :: "+ columnTransformerDemos.size());
		assertThat(columnTransformerDemos.size(), greaterThan(1));
	}
	
	@Test
	public void updateEntityTest() {
		System.out.println("------------------------------------- updateEntityTest---------------------------------------------");
		ColumnTransformerDemo demo = em.find(ColumnTransformerDemo.class, pk);
		assertNotNull(demo);
		demo.setWeightInPound(155d);
		em.flush();
		em.refresh(demo);
		assertThat(demo.getWeightInPound().longValue(), equalTo(154L));
	}
	
}
