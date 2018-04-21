package com.example.hibernate.model.identity.hibernate;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enhanced_sequence_identity_strategy")
public class EnhanceSequenceStrategy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4708075618325961435L;
	
	@Id
	@GeneratedValue(generator = "enhanced_sequence_identity_generator")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
