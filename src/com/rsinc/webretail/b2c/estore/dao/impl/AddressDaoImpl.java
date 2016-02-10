/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.dao.AddressDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public class AddressDaoImpl<T> extends BaseDaoImpl<T> implements AddressDao<T>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
