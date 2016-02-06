/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.dao.UserDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public class UserDaoImpl<T> extends BaseDaoImpl<T> implements UserDao<T>{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public List<T> fetchAllUsers() {
		return findWithNamedQuery("");
	}

}
