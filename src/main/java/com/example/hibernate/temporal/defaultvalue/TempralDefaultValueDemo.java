package com.example.hibernate.temporal.defaultvalue;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "tempral_default_value_demo")
public class TempralDefaultValueDemo implements Serializable {

	private static final long serialVersionUID = -3759419057180280004L;

	@Basic
	@Id
	@GeneratedValue(generator = "tempral_default_value_demo_id_gen")
	@SequenceGenerator(name = "tempral_default_value_demo_id_gen", sequenceName = "tempral_default_value_demo_id_gen")
	@Column(name = "id")
	private Long id;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date")
	private Calendar createdDate;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "updated_date")
	private Calendar updatedDate;
	
	@Column(name = "foo")
	private String foo;

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

	public Long getId() {
		return id;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}
}
