package com.example.hibernate.locking.optimistic;

import static org.junit.Assert.assertEquals;

import javax.persistence.OptimisticLockException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientTest extends BaseTest {

	private static Long pk = null;
	private static Long permistic_lock_version = null;

	@Test
	public void atest() {
		Patient patient = new Patient();
		patient.setPastMedicalHistory("patient is suffereing from injuries");
		em.persist(patient);

		pk = patient.getPatientId();
		permistic_lock_version = patient.getVersion();
	}

	@Test(expected = OptimisticLockException.class)
	public void btest2() {
		Patient patient = new Patient();
		patient.setPastMedicalHistory("patient is suffereing from chest pain");
		patient.setPatientId(pk);
		patient.setVersion(permistic_lock_version - 1);

		// this merge operation will throw javax.persistence.OptimisticLockException
		em.merge(patient);
	}

	@Test
	public void ctest() {
		int rowsupdated = em.createQuery(
				"UPDATE Patient p SET p.pastMedicalHistory = :pastMedicalHistory, p.version = p.version + 1 WHERE p.patientId = :patientId AND p.version = :version")
				.setParameter("patientId", pk).setParameter("version", permistic_lock_version - 1).setParameter("pastMedicalHistory", "foo").executeUpdate();

		assertEquals(0, rowsupdated);
	}

}
