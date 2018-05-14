package com.example.hibernate.temporal.defaultvalue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TempralDefaultValueDemoTest extends BaseTest {

	private static Long pk;
	
	@Test
	public void persistTest() {
		TempralDefaultValueDemo defaultValueDemo = new TempralDefaultValueDemo();
		defaultValueDemo.setFoo("asdads");
		em.persist(defaultValueDemo);
		pk = defaultValueDemo.getId();
	}
	
	@Test
	public void updateTest() throws InterruptedException {
		Thread.sleep(10000);
		TempralDefaultValueDemo defaultValueDemo = em.find(TempralDefaultValueDemo.class, pk);
		defaultValueDemo.setFoo("23423423asdad");
	}
}
