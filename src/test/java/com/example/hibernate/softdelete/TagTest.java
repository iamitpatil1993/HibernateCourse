/**
 * 
 */
package com.example.hibernate.softdelete;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

/**
 * @author amit patil
 * Test case to demo soft deletion of Tag Entity
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TagTest extends BaseTest {

	private static Long tagId = null;
	@Test
	public void aPersistTest() {
		Tag tag = new Tag();
		tag.setTag("Hibernate");
		em.persist(tag);
		assertNotNull(tag.getTagId());
		tagId = tag.getTagId();
	}

	@Test
	public void bMergeTest() {
		Tag tag = em.find(Tag.class, tagId);
		assertNotNull(tag);
		assertTrue(em.contains(tag));
		
		tag.setTag("JPA");
		em.merge(tag);
	}
	
	@Test
	public void cRemoveTest() {
		Tag tag = em.getReference(Tag.class, tagId);
		assertNotNull(tag);
		assertTrue(em.contains(tag));
		em.remove(tag);
	}

	@Test
	public void dFindTest() {
		Tag tag = em.find(Tag.class, tagId);
		assertNull(tag);
	}
}
