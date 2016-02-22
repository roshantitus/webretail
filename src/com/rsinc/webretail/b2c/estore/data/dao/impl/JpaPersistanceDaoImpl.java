/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public class JpaPersistanceDaoImpl<T> implements PersistanceDao<T> {


	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 
	 */
	public JpaPersistanceDaoImpl() {

	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#create(java.lang.Object)
	 */
	@Override
	public T create(T t)  throws PersistanceFailureSystemException, RecordAlreadyExistsException{
		try {
			getEntityManager().persist(t);
			getEntityManager().flush();
			getEntityManager().refresh(t);
			return t;
		} catch (EntityExistsException e) {
			throw new RecordAlreadyExistsException(t.getClass() + " record already exists. " + t.toString(), e);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new PersistanceFailureSystemException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public T update(T t) throws PersistanceFailureSystemException{
		try {
			return getEntityManager().merge(t);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new PersistanceFailureSystemException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#delete(java.lang.Class, java.lang.Object)
	 */
	@Override
	public void delete(Class<T> type, Object id)  throws PersistanceFailureSystemException, RecordNotFoundException{
		try {
			Object ref = getEntityManager().getReference(type, id);
			getEntityManager().remove(ref);
		} catch (EntityNotFoundException e) {
			throw new RecordNotFoundException(type + " record not found. ID=" + id.toString(), e);			
		} catch (IllegalArgumentException | PersistenceException e) { 
			throw new PersistanceFailureSystemException(e);
		}
	}
	
	@Override
	public void delete(T t) throws PersistanceFailureSystemException{
		try {
			getEntityManager().remove(t);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new PersistanceFailureSystemException(e);
		}
	}
	

	@Override
	public List<T> bulkCreate(List<T> entities)  throws PersistanceFailureSystemException, RecordAlreadyExistsException{

		int i = 0;
		  for (T t : entities) 
		  {
		  	try {				  
				getEntityManager().persist(t);
			    i++;
			    if (i % Constants.BATCH_SIZE == 0) {
			    	// Flush a batch of inserts and release memory.
			    	getEntityManager().flush();
			    	getEntityManager().clear();
			    }			    
			} catch (EntityExistsException e) {
				throw new RecordAlreadyExistsException(t.getClass() + " record already exists. " + t.toString(), e);
			} catch (IllegalArgumentException | PersistenceException e) {
				throw new PersistanceFailureSystemException(e);
			}			    
		  }
		  return entities;		  
	}

	@Override
	public List<T> bulkUdate(List<T> entities)  throws PersistanceFailureSystemException{
		
		int i = 0;
		  for (T t : entities) 
		  {
			try{
				getEntityManager().merge(t);
			    i++;
			    if (i % Constants.BATCH_SIZE == 0) {
			    	// Flush a batch of inserts and release memory.
			    	getEntityManager().flush();
			    	getEntityManager().clear();
			    }
			} catch (IllegalArgumentException | PersistenceException e) {
				throw new PersistanceFailureSystemException(e);
			}				    
		  }
		  return entities;
	}	

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#find(java.lang.Class, java.lang.Object)
	 */
	@Override
	public T find(Class<T> type, Object id)  throws RetrievalFailureSystemException, RecordNotFoundException{
		T result = null;
		try {
			result = getEntityManager().find(type, id);
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
		if(null == result)
		{
			throw new RecordNotFoundException(type + " record not found. ID=" + id.toString());
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findWithNamedQuery(String queryName)  throws RetrievalFailureSystemException{
		List<T> result = null;
		try {
			result = getEntityManager().createNamedQuery(queryName).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;		
	}


	@Override
	public List<T> findAll(Class<T> entityClass)  throws RetrievalFailureSystemException{
		List<T> result = null;
		try {
			//Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			Query query = getEntityManager().createQuery("from " + entityClass.getName());
			result = query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String, java.util.Map)
	 */
	@Override
	public List<T> findWithNamedQuery(String queryName, Map<String, Object> params)  throws RetrievalFailureSystemException{
		List<T> result = null;
//		try {
//			result = getEntityManager().createNamedQuery(queryName).getResultList();
//		} catch (IllegalArgumentException | PersistenceException e) {
//			throw new RetrievalFailureSystemException(e);
//		}		
		return result;	
	}
}
