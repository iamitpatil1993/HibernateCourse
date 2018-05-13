package com.example.hibernate;
import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;

public class HibernateNativeBaseClass {

	private static final SessionFactory SESSION_FACTORY;
	private static final String HIBERNAYE_CONFIG_FILE = "hibernate.cfg.xml";
	private Session currentSession = null;
	private Transaction currentTransaction = null;

	static {
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure(getFile(HIBERNAYE_CONFIG_FILE)).build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		SESSION_FACTORY = metadata.getSessionFactoryBuilder().build();
	}

	private static File getFile(String fileName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return new File(classLoader.getResource(fileName).getFile());
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	@Before
	public void beforeTest() {
		currentSession = SESSION_FACTORY.getCurrentSession();
		currentTransaction = currentSession.getTransaction();
		currentTransaction.begin();
	}
	
	@After
	public void afterTest() {
		currentTransaction.commit();
		currentSession.close();
	}

	public Session getCurrentSession() {
		return currentSession;
	}
	
	
}
