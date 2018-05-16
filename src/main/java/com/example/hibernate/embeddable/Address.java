package com.example.hibernate.embeddable;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Access(AccessType.FIELD)
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Basic
	@NotNull
	@Size(max = 30)
	@Column(name = "city")
	private String city;

	@Basic
	@NotNull
	@Size(max = 60)
	@Column(name = "street")
	private String street;

	@Basic
	@NotNull
	@Size(max = 50)
	@Column(name = "state")
	private String state;

	@Basic
	@NotNull
	@Size(max = 40)
	@Column(name = "country")
	private String coluntry;

	// @Embeddable no need of this annotation this is implicit
	@NotNull
	@Valid
	private OfficeAddress officeLocation;

	public Address(String city, String street, String state, String coluntry, OfficeAddress officeAddress) {
		this.city = city;
		this.street = street;
		this.state = state;
		this.coluntry = coluntry;
		this.officeLocation = officeAddress;
	}

	public Address() {
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getColuntry() {
		return coluntry;
	}

	public void setColuntry(String coluntry) {
		this.coluntry = coluntry;
	}

	public OfficeAddress getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(OfficeAddress officeLocation) {
		this.officeLocation = officeLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((coluntry == null) ? 0 : coluntry.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (coluntry == null) {
			if (other.coluntry != null)
				return false;
		} else if (!coluntry.equals(other.coluntry))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
