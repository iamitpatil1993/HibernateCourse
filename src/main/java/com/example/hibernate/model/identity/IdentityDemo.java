package com.example.hibernate.model.identity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "identity_demo")
public class IdentityDemo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "identity_demo_seq")
	@SequenceGenerator(name = "identity_demo_seq", allocationSize = 50,
	sequenceName = "identity_demo_id_seq")
	private Long id;	
	
	private String foo;

	public Long getId() {
		return id;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}
}
