package com.example.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.example.hibernate.model.Message;

public class HelloWorld {

	public static void main(String[] argv) {
		getMessageById(createMessage());
	}

	// Message object received from entity manager here is managed.
	private static void getMessageById(Long messageId) {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPADB");
		EntityManager entityManager = managerFactory.createEntityManager();
		Message mes = entityManager.find(Message.class, messageId);
		System.out.println("Message found by messageId :: " + messageId + " message :: " + mes);
		System.out.println("Is message managed in persistence context ? -> " + entityManager.contains(mes));
		entityManager.close();
	}

	// Transaction is manadatory to perform dml operations, so if I remove transaction code from below method, it will not throw exception
	//but entity will not get saved to database and message.getMessageId() will return null
	private static Long createMessage() {
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("JPADB");
		EntityManager entityManager = managerFactory.createEntityManager();
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Message message = new Message();
		message.setMessage("Hello World Hibernate");
		
		entityManager.persist(message);
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Message created with messageId :: " + message.getMessageId());
		return message.getMessageId();
	}
}
