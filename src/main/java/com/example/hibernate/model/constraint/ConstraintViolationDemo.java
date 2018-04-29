package com.example.hibernate.model.constraint;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "constraint_violation")
public class ConstraintViolationDemo implements Serializable {

	private static final long serialVersionUID = 18630841626223792L;

	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "constraint_violation_id_gen")
	@SequenceGenerator(name = "constraint_violation_id_gen", sequenceName = "constraint_violation_seq_gen")
	@Column(name = "id")
	private Long id;

	// I have added unique constraint on email to test unique constraint violation case and handle it correctly in code.
	@Basic
	@Column(name = "email", unique = true)
	private String email;

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
