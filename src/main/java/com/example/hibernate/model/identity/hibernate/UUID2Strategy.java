package com.example.hibernate.model.identity.hibernate;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author amit patil This entity is used to test UUID support by hibernate. In
 *         this test, we will use hiberbate's uuid2 stategy, which will generate
 *         primary key for us.
 * 
 *
 */

@Entity
@Table(name = "uuid2_strategy")
public class UUID2Strategy implements Serializable {

	private static final long serialVersionUID = -3896762295145090687L;

	@Basic
	@Id
	@GeneratedValue(generator = "uuid2_generator")
	@GenericGenerator(name = "uuid2_generator", strategy = "uuid2")
	@Column(name = "id")
	private UUID id;

	@Basic
	@Column(name = "foo")
	private String foo;

	public UUID getId() {
		return id;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}
}
