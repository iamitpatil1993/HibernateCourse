package com.example.hibernate.access.override.newmethod;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AccessOverrideDemo
 *
 */
@Entity
@Table(name = "access_override_demo")

public class AccessOverrideDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "access_override_demo_id_gen")
	@SequenceGenerator(name = "access_override_demo_id_gen", sequenceName = "access_override_demo_id_gen")
	@Column(name = "id")
	private Long id;

	// all metadata annotations will be here at field only, but only runtime access
	// of field name will be via access methods
	// we do not need to set access type at class level, mark field transient and add annotations at getter.
	// using this method, consistency is get maintained i.e all metadata annotations will be on field
	// irrespective of how field will be accessed at runtime
	@Basic
	@Access(AccessType.PROPERTY) // just specify that this field will be accessed via property at runtime
	@Column(name = "name")
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name.split(" ")[0];
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name + "foo";
	}
}
