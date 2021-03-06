package com.example.hibernate.nativeapi;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.hibernate.model.Message;

public class SessionFactoryExample {

	public static void main(String[] args) {
		
		String[] arr = "sas,as,d".split(",");
		System.out.println(Arrays.asList(arr));
		//createMessage();
	}

	private static Long createMessage() {

		Session session = SessionFactoryBootstrap.getSessionFactory().getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		Message message = new Message();
		message.setMessage("Hello World Hibernate Native API...");

		session.persist(message);

		transaction.commit();
		System.out.println("Message created Successfully with Id :: " + message.getMessageId());
		return message.getMessageId();
	}

}
