package com.example.hibernate.embeddable;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest extends BaseTest {

	private static Long pk = null;
	@Test
	public void apersistTest() {
		User user = new User();
		user.setAddress(new Address("Pune", "Gajanan Hos. Soc,", "Maharashtra", "India", new OfficeAddress("PX23234")));
		em.persist(user);
		pk = user.getId();
		assertNotNull(pk);
	}
	
	@Test
	public void fetchTest() {
		User user = em.find(User.class, pk);
		assertNotNull(user);
		assertNotNull(user.getAddress());
	}
}
