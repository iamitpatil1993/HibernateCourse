package com.example.hibernate.access.property;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: PropertyAccessDemo
 *
 */
@Entity
@Table(name = "property_access_demo")

public class PropertyAccessDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String foo;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "property_access_demo_id_gen")
	@SequenceGenerator(name = "property_access_demo_id_gen", sequenceName = "property_access_demo_id_gen")
	@Column(name = "id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

}
