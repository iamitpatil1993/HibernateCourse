/**
 * 
 */
package com.example.hibernate.model.identity;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.example.hibernate.model.identity.hibernate.BaseTest;

/**
 * @author amit patil
 * This test case will test impact of Custom Identity generation at business/application layer by our application code rather than hibernate or database.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomIdentityGenerationStrategyTest extends BaseTest {

	static private Long primaryKey = null;
	@Test
	public void aPersistWithTransientEntityTest() {
		primaryKey = System.currentTimeMillis();
		CustomIdentityGenerationStrategy customIdentityGenerationStrategy = new CustomIdentityGenerationStrategy(primaryKey);
		em.persist(customIdentityGenerationStrategy);
		assertNotNull(customIdentityGenerationStrategy.getId());
		System.out.println("-------------------- Persiting New Entity with primary key :: " + primaryKey + "-----------------");
	}
	
	@Test()
	public void bMergeWithExistingPrimaryKeyTest() {
		CustomIdentityGenerationStrategy customIdentityGenerationStrategy = new CustomIdentityGenerationStrategy(primaryKey);
		em.merge(customIdentityGenerationStrategy);
		System.out.println("-------------------- Merging Entity with exiting primary key(You can say detached entity) :: " + primaryKey + "-----------------");
		System.out.println("-------------------- Hibernate won't execute INSERT becuse entity with same key already exists in databse -----------------------");
	}
	
	@Test()
	public void bMergeWithNewEntityTest() {
		CustomIdentityGenerationStrategy customIdentityGenerationStrategy = new CustomIdentityGenerationStrategy(System.currentTimeMillis());
		em.merge(customIdentityGenerationStrategy);
		System.out.println("------------------- Hibernate Merge with Transient Entity ---------------------------------------------------------------------------");
		System.out.println("------------------ Hibernate will Select and check entity with Id exits, since it not, it will execute INSERT statement---------------");
	}
	
	@Test
	public void cMergeWithNotModifiedManagedEntity() {
		CustomIdentityGenerationStrategy managedEntity = em.find(CustomIdentityGenerationStrategy.class, primaryKey);
		assertNotNull("Entity Not found by identity :: " + primaryKey, managedEntity);
		assertTrue("Entity is not managed", em.contains(managedEntity));
		em.merge(managedEntity);
		System.out.println("------------------- Hibernate merge operatrion will no do anything if entity is managed and not modified --------------------------------");
	}
	
	
	@Test
	public void dMergeWithModifiedManagedEntity() {
		CustomIdentityGenerationStrategy managedEntity = em.find(CustomIdentityGenerationStrategy.class, primaryKey);
		assertNotNull("Entity Not found by identity :: " + primaryKey, managedEntity);
		assertTrue("Entity is not managed", em.contains(managedEntity));
		managedEntity.setFoo("Amit Rocks");
		em.merge(managedEntity);
		System.out.println("------------------- Hibernate merge operatrion will select and updtae the entity --------------------------------");
	}
}
