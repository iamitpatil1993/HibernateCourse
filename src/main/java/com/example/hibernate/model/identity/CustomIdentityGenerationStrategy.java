package com.example.hibernate.model.identity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 
 * @author amit patil
 * 
 * Here Using this entity I am trying to generate custom Identity at application level and will check it's impact on 
 * entity manager's persist and merge operations.
 * I am using Long as data type, in next commit You will see custom Identity gerration using UUID
 *
 */

@Entity
@Table(name = "custom_identity_generation_strategy")
public class CustomIdentityGenerationStrategy implements Serializable {

	private static final long serialVersionUID = -2861986778008063282L;

	
	@Basic
	@Id
	@Column(name = "id")
	private Long id;
	
	@Basic
	@Column(name = "foo")
	private String foo;
	
	public CustomIdentityGenerationStrategy() {
		// Noting to do here, default constructor kept ass it is, since hiberntae might be using it internally.
	}
	
	// This constructor will be used to manually assign primary key at application/business layer to entity and to create transient entity.
	public CustomIdentityGenerationStrategy(final Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	// Never provide setter method for primary key, since Identity of Entity must be immutable as per hibername/jpa standard
	
	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}
}
