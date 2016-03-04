/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
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


	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass)  throws RetrievalFailureSystemException{
		List<T> result = null;
		try {
			TypedQuery<T> query = createQuery(entityClass);
			result = query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> entityClass, ResultLoadCriteria resultLoadCriteria)  throws RetrievalFailureSystemException{
		List<T> result = null;
		try {
			TypedQuery<T> query = createQuery(entityClass);
			setResultLoadCriteria(query, resultLoadCriteria);			
			result = query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;
	}



	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao#getTotalRecordCount(java.lang.Class)
	 */
	@Override
	public Long getTotalRecordCount(Class<T> entityClass)
			throws RetrievalFailureSystemException {
		Long result = null;
		try {
			TypedQuery<Long> query = createCountQuery(entityClass);
			result = (Long) query.getSingleResult();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;
	}


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao#getTotalRecordCount(java.lang.Class, com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalRecordCount(Class<T> entityClass,
			ResultLoadCriteria resultLoadCriteria)
			throws RetrievalFailureSystemException {
		Long result = null;
		try {
			TypedQuery<Long> query = createCountQuery(entityClass);
			setResultLoadCriteriaForCountQuery(query, resultLoadCriteria);			
			result = (Long) query.getSingleResult();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}		
		return result;
	}	

	/**
	 * @param query
	 * @param resultLoadCriteria
	 */
	private void setResultLoadCriteria(Query query,
			ResultLoadCriteria resultLoadCriteria) {
		if(null != resultLoadCriteria.getFirst())
		{
			query.setFirstResult(resultLoadCriteria.getFirst());
		}
		if(null != resultLoadCriteria.getPageSize())
		{
			query.setMaxResults(resultLoadCriteria.getPageSize());
		}
	}

	private void setResultLoadCriteriaForCountQuery(Query query,
			ResultLoadCriteria resultLoadCriteria) {

	}
	
	/**
	 * @param entityClass
	 * @return
	 */
	private TypedQuery<T> createQuery(Class<T> entityClass) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
		Root<T> from = criteriaQuery.from(entityClass);
		return getEntityManager().createQuery(criteriaQuery);
	}	

	private TypedQuery<Long> createCountQuery(Class<T> entityClass) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = cb.createQuery(Long.class);
		criteriaQuery.select(cb.count(criteriaQuery.from(entityClass)));
		return getEntityManager().createQuery(criteriaQuery);
	}	

	/* (non-Javadoc)
	 * @see com.rs.webretail.b2c.estore.dao.BaseDao#findWithNamedQuery(java.lang.String, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findWithNamedQuery(String namedQueryName, Map<String, Object> params)  throws RetrievalFailureSystemException{

		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);		
			Set<Entry<String, Object>> rawParameters = params.entrySet();		
			for(Entry<String, Object> entry : rawParameters)		
			{		
				query.setParameter(entry.getKey(), entry.getValue());		
			}	
			return query.getResultList();
			
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<T> findWithNamedQuery(String namedQueryName, List params)  throws RetrievalFailureSystemException	
	{	
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			int i = 1;
			for(Object obj: params)
			{
				query.setParameter(i, obj);
				i++;
			}
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	 	
	public List<T> findWithNamedQuery(String queryName, int resultLimit)  throws RetrievalFailureSystemException	
	{	
		try {
			Query query = getEntityManager().createNamedQuery(queryName);
			if(resultLimit > 0)
			{
				query.setMaxResults(resultLimit);
			}	
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<T> findWithNamedQuery(String namedQueryName, Map params, int resultLimit)  throws RetrievalFailureSystemException	
	{	
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);	
			if(resultLimit > 0)
			{
				query.setMaxResults(resultLimit);
			}		
			Set<Entry> rawParameters = params.entrySet();		
			for(Entry<String, Object> entry : rawParameters)		
			{		
				query.setParameter(entry.getKey(), entry.getValue());		
			}		
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override	 
	public List<T> findWithNamedQuery(String namedQueryName, List params, int resultLimit)  throws RetrievalFailureSystemException	
	{
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			if(resultLimit > 0)
			{
				query.setMaxResults(resultLimit);
			}		
			int i = 1;
			for(Object obj: params)
			{
				query.setParameter(i, obj);
				i++;
			}
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List<T> findWithNamedQueryWithINClause(String namedQueryName, List params)  throws RetrievalFailureSystemException	
	{	
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			query.setParameter("params", params);
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}	
	


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao#findWithNamedQueryWithINClause(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria, java.lang.String, java.util.List)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findWithNamedQueryWithINClause(
			ResultLoadCriteria resultLoadCriteria, String namedQueryName,
			List params) throws RetrievalFailureSystemException {
		
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			query.setParameter("params", params);
			setResultLoadCriteria(query, resultLoadCriteria);				
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao#getCountWithNamedQueryWithINClause(java.lang.String, java.util.List)
	 */
	@Override
	public Object findSingleResultWithINClause(String namedQueryName,
			List params) throws RetrievalFailureSystemException {
		try {
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			query.setParameter("params", params);			
			return query.getSingleResult();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}	
	
	
	@SuppressWarnings("unchecked")
	@Override	 	
	public List findByNativeQuery(String sql, Class type)  throws RetrievalFailureSystemException
	{
		try {
			Query query = getEntityManager().createNativeQuery(sql, type);
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	 	
	public List findByNativeQuery(String sql, Class type, List params)  throws RetrievalFailureSystemException
	{
		try {
			Query query = getEntityManager().createNativeQuery(sql, type);
			int i = 1;
			for(Object obj: params)
			{
				query.setParameter(i, obj);
				i++;
			}
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override	
	public List findByNativeQuery(String sql, Class type, List params, int resultLimit)  throws RetrievalFailureSystemException
	{
		try {
			Query query = getEntityManager().createNativeQuery(sql, type);
			if(resultLimit > 0)
			{
				query.setMaxResults(resultLimit);
			}		
			int i = 1;		
			for(Object obj: params)		
			{		
				query.setParameter(i, obj);			
				i++;		
			}		
			return query.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			throw new RetrievalFailureSystemException(e);
		}
	}



	
}
