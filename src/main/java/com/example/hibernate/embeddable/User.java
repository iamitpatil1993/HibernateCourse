package com.example.hibernate.embeddable;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_embeddable_demo")
public class User implements Serializable {

	private static final long serialVersionUID = 8997884645436360940L;

	@Basic
	@Id
	@GeneratedValue(generator = "user_id_gen")
	@SequenceGenerator(name = "user_id_gen", sequenceName = "user_seq_gen")
	@Column(name = "id")
	private Long id;

	// @Embedded annotation is optional, hibernate knows this object is embeddable
	@AttributeOverride(name = "officeLocation.officeNo", column = @Column(name = "office_no"))
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}
}
