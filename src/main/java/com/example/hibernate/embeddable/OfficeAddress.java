package com.example.hibernate.embeddable;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class OfficeAddress implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "office_number")
	private String officeNo;
	
	public OfficeAddress(String officeNo) {
		this.officeNo = officeNo;
	}
	
	public OfficeAddress() {
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((officeNo == null) ? 0 : officeNo.hashCode());
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
		OfficeAddress other = (OfficeAddress) obj;
		if (officeNo == null) {
			if (other.officeNo != null)
				return false;
		} else if (!officeNo.equals(other.officeNo))
			return false;
		return true;
	}
}
