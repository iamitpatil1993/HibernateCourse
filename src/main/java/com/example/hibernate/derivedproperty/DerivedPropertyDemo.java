package com.example.hibernate.derivedproperty;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "derived_property_demo")
public class DerivedPropertyDemo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@Id
	@GeneratedValue(generator = "derived_property_demo_seq_gen")
	@SequenceGenerator(name = "derived_property_demo_seq_gen", sequenceName = "derived_property_demo_seq_gen")
	@Column
	private Long id;

	@org.hibernate.annotations.Formula("id*2")
	private Long derivedField;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDerivedField() {
		return derivedField;
	}

	public void setDerivedField(Long derivedField) {
		this.derivedField = derivedField;
	}	
}
