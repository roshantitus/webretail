/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.data.dao.PartyDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public class PartyDaoImpl<T> extends BaseDaoImpl<T> implements PartyDao<T>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
