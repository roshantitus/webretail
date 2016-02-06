/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.dao.BaseDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	public abstract EntityManager getEntityManager();
	
	/**
	 * 
	 */
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#create(java.lang.Object)
	 */
	@Override
	public T create(T t) {
		getEntityManager().persist(t);
		getEntityManager().flush();
		getEntityManager().refresh(t);
		return t;
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public T update(T t) {
		return (T) getEntityManager().merge(t);
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#delete(java.lang.Class, java.lang.Object)
	 */
	@Override
	public void delete(Class<T> type, Object id) {
		Object ref = getEntityManager().getReference(type, id);
		getEntityManager().remove(ref);
	}
	
	@Override
	public void delete(T t){
		getEntityManager().remove(t);
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#find(java.lang.Class, java.lang.Object)
	 */
	@Override
	public T find(Class<T> type, Object id) {
		return(T) getEntityManager().find(type, id);
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String)
	 */
	@Override
	public List<T> findWithNamedQuery(String queryName) {
		return getEntityManager().createNamedQuery(queryName).getResultList();
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public List<T> findWithNamedQuery(String queryName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

}
