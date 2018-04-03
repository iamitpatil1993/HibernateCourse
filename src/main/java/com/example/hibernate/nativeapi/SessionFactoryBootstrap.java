package com.example.hibernate.nativeapi;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryBootstrap {

	private static final SessionFactory SESSION_FACTORY;
	private static final String HIBERNAYE_CONFIG_FILE = "hibernate.cfg.xml";

	private SessionFactoryBootstrap() {
		// Nothing to do here	
	}

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

}
