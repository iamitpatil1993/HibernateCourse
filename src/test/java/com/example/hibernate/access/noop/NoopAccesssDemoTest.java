package com.example.hibernate.access.noop;

import java.util.List;

import org.hibernate.query.Query;
import org.junit.Test;

import com.example.hibernate.HibernateNativeBaseClass;

public class NoopAccesssDemoTest extends HibernateNativeBaseClass {

	@Test
	public void test() {
		NoopAccesssDemo accesssDemo = new NoopAccesssDemo();
		getCurrentSession().persist(accesssDemo);

		Query<String> query = getCurrentSession().createQuery("SELECT volatileProperty FROM NoopAccesssDemo",
				String.class);
		List<String> volatileProperties = query.getResultList();

		volatileProperties.stream().forEach(System.out::println);
	}
}
