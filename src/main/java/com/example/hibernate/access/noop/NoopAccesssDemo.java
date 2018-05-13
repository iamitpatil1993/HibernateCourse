package com.example.hibernate.access.noop;

import java.io.Serializable;

public class NoopAccesssDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String volatileProperty;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVolatileProperty() {
		return volatileProperty;
	}

	public void setVolatileProperty(String volatileProperty) {
		this.volatileProperty = volatileProperty;
	}
}
