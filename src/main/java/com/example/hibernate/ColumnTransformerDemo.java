package com.example.hibernate;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

@Entity
@Table(name = "column_transformer_demo")
public class ColumnTransformerDemo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Id
	@GeneratedValue(generator = "column_transformer_demo_id_gen")
	@SequenceGenerator(name = "column_transformer_demo_id_gen", sequenceName = "column_transformer_demo_id_gen")
	@Column(name = "id")
	private Long id;
	
	@Basic
	@ColumnTransformer(
			read = "weight * 2.20462262",
			write = "? * 0.45359237"
	)
	@Column(name = "weight")
	private Double weightInPound;

	public Long getId() {
		return id;
	}

	public Double getWeightInPound() {
		return weightInPound;
	}

	public void setWeightInPound(Double weightInPound) {
		this.weightInPound = weightInPound;
	}
}
