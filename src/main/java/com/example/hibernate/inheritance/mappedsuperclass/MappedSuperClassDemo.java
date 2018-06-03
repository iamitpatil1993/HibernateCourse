package com.example.hibernate.inheritance.mappedsuperclass;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: MappedSuperClassDemo
 *
 */
@Entity
@Table(name = "mapped_super_class_demo")
public class MappedSuperClassDemo extends AuditLog {

	private static final long serialVersionUID = 3319176748793887819L;

	@Basic
	@Column(name = "foo")
	private String foo;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

}
