package com.example.hibernate.locking.optimistic;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Patient
 *
 */
@Entity
@Table(name = "patirnt")

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic
	@GeneratedValue(generator = "patient_id_gen")
	@SequenceGenerator(allocationSize = 1, name = "patient_id_gen", sequenceName = "patient_id_seq_gen")
	@Column(name = "patient_id")
	private Long patientId;

	@Basic
	@Column(name = "past_medical_history")
	private String pastMedicalHistory;

	@Version
	@Column(name = "opt_lock_version")
	private Long version;

	public Long getPatientId() {
		return patientId;
	}

	public String getPastMedicalHistory() {
		return pastMedicalHistory;
	}

	public void setPastMedicalHistory(String pastMedicalHistory) {
		this.pastMedicalHistory = pastMedicalHistory;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

}
