/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.data.dao.BaseDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public abstract class BaseDaoImpl<T> implements BaseDao<T> {


	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 */
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
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
		return getEntityManager().merge(t);
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
		return getEntityManager().find(type, id);
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
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

	@Override
	public List<T> findAll(Class<T> entityClass) {
		
		//Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = getEntityManager().createQuery("from " + entityClass.getName());
	    return query.getResultList();
	}

	@Override
	public List<T> bulkCreate(List<T> entities) {
		  int i = 0;
		  for (T t : entities) {
			getEntityManager().persist(t);
		    i++;
		    if (i % Constants.BATCH_SIZE == 0) {
		    	// Flush a batch of inserts and release memory.
		    	getEntityManager().flush();
		    	getEntityManager().clear();
		    }
		  }
		  return entities;
	}

	@Override
	public List<T> bulkUdate(List<T> entities) {
		  int i = 0;
		  for (T t : entities) {
			getEntityManager().merge(t);
		    i++;
		    if (i % Constants.BATCH_SIZE == 0) {
		    	// Flush a batch of inserts and release memory.
		    	getEntityManager().flush();
		    	getEntityManager().clear();
		    }
		  }
		  return entities;
	}

}
