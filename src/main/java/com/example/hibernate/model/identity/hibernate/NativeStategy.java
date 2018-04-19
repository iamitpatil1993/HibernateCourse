package com.example.hibernate.model.identity.hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "native_identity_generation")
public class NativeStategy implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Generator is defined in package-info.java
	@Id
	@GeneratedValue(generator = "native_identity_generator")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}