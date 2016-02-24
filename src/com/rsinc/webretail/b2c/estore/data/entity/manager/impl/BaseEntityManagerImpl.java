/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.common.util.SecurityContextUtils;
import com.rsinc.webretail.b2c.estore.data.dao.PersistanceDao;
import com.rsinc.webretail.b2c.estore.data.dao.QueryDao;
import com.rsinc.webretail.b2c.estore.data.entity.BaseBean;
import com.rsinc.webretail.b2c.estore.data.entity.manager.BaseEntityManager;

/**
 * @author Roshan Titus 
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public abstract class BaseEntityManagerImpl <T extends BaseBean> implements BaseEntityManager <T> {

	@Inject
	private PersistanceDao<T> persistanceDao;
	
	@Inject
	private QueryDao queryDao;
	
	/**
	 * 
	 */
	public BaseEntityManagerImpl() {
	}
	
	

	public QueryDao getQueryDao() {
		return queryDao;
	}


	protected PersistanceDao<T> getPersistanceDao() {
		return persistanceDao;
	}
	
	
	@Override
	public void setDefaultValues(T baseBean) {
	
		if(null == baseBean.getCreatedBy())
		{
			baseBean.setCreatedBy(SecurityContextUtils.getLoggedInUserId());
		}
		
		if(null == baseBean.getCreatedDate())
		{		
			baseBean.setCreatedDate(Calendar.getInstance());
		}
		
		if(null == baseBean.getDeletedYN())
		{	
			baseBean.setDeletedYN(Constants.False);
		}
		
		if(null == baseBean.getRecordVersionNo())
		{		
			baseBean.setRecordVersionNo(Constants.ZERO);
		}
		
		if(null == baseBean.getUpdatedBy())
		{			
			baseBean.setUpdatedBy(SecurityContextUtils.getLoggedInUserId());
		}
		
		if(null == baseBean.getUpdatedDate())
		{		
			baseBean.setUpdatedDate(Calendar.getInstance());
		}
	}

	@Override
	public void validateForCreate(T baseBean) throws ValidationException{
		// TODO validate and throw ValidationException
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object cannot be null"); 
		}	
		if(null != baseBean.key())
		{
			throw new IllegalArgumentException("Id should be null for create"); 
		}
	}
	
	@Override
	public void validateForUpdate(T baseBean) throws ValidationException{
		// TODO Auto-generated method stub
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}
		if(null == baseBean.key())
		{
			throw new IllegalArgumentException("Id cannot be null for update"); 
		}		
	}

	@Override
	public void validateForDelete(T baseBean) throws ValidationException{
		// TODO Auto-generated method stub
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}		
		if(null == baseBean.key())
		{
			throw new IllegalArgumentException("Id cannot be null for delete"); 
		}			
	}
	
	private void validateForId(Object id) throws ValidationException{
		if(null == id)
		{
			throw new IllegalArgumentException("Id cannot be null for delete"); 
		}			
	}	
	
	@Override
	public T create(T baseBean)  throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException{
		
		validateForCreate(baseBean);
		setDefaultValues(baseBean);		
		return getPersistanceDao().create(baseBean);
	}

	@Override
	public T update(T baseBean)  throws PersistanceFailureSystemException, ValidationException{
	
		validateForUpdate(baseBean);
		return (T)getPersistanceDao().update(baseBean);
	}
	

	@Override
	public void delete(T baseBean)  throws PersistanceFailureSystemException, ValidationException{

		validateForDelete(baseBean);
		getPersistanceDao().delete(baseBean);
	}	

	public abstract void deleteById(Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException;
	
	@Override
	public void deleteById(Class<T> type, Object id) throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException{
		
		validateForId(id);
		getPersistanceDao().delete(type, id);
	}


	@Override
	public List<T> bulkCreate(List<T> entities)  throws PersistanceFailureSystemException, RecordAlreadyExistsException, ValidationException{
		for(T baseBean : entities)
		{
			validateForCreate(baseBean);
			setDefaultValues(baseBean);				
		}
		return getPersistanceDao().bulkCreate(entities);
	}

	@Override
	public List<T> bulkUdate(List<T> entities)  throws PersistanceFailureSystemException, ValidationException{
		for(T baseBean : entities)
		{
			validateForUpdate(baseBean);		
		}
		return getPersistanceDao().bulkUdate(entities);
	}

	@Override
	public T load(Class<T> type, Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException{
		
		validateForId(id);		
		return getPersistanceDao().find(type, id);
	}

	public abstract T loadById(Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;

	public abstract List<T> findAll() throws RetrievalFailureSystemException;

	@Override
	public List<T> findAll(Class<T> type)
			throws RetrievalFailureSystemException {

		return getPersistanceDao().findAll(type);
	}



	@Override
	public List<T> findWithNamedQuery(String queryName)
			throws RetrievalFailureSystemException {

		return getPersistanceDao().findWithNamedQuery(queryName);
	}



	@Override
	public List<T> findWithNamedQuery(String queryName,
			Map<String, Object> params) throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findWithNamedQuery(queryName, params);
	}



	@Override
	public List<T> findWithNamedQuery(String namedQueryName, List params)
			throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findWithNamedQuery(namedQueryName, params);
	}



	@Override
	public List<T> findWithNamedQuery(String queryName, int resultLimit)
			throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findWithNamedQuery(queryName, resultLimit);
	}



	@Override
	public List<T> findWithNamedQuery(String namedQueryName, Map params,
			int resultLimit) throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findWithNamedQuery(namedQueryName, params,
				resultLimit);
	}



	@Override
	public List<T> findWithNamedQuery(String namedQueryName, List params,
			int resultLimit) throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findWithNamedQuery(namedQueryName, params,
				resultLimit);
	}



	@Override
	public List findByNativeQuery(String sql, Class type)
			throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findByNativeQuery(sql, type);
	}



	@Override
	public List findByNativeQuery(String sql, Class type, List params)
			throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findByNativeQuery(sql, type, params);
	}



	@Override
	public List findByNativeQuery(String sql, Class type, List params,
			int resultLimit) throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findByNativeQuery(sql, type, params, resultLimit);
	}

	
	//Query methods

	@Override
	public <E> List<E> queryForList(String query, Class<E> clazz)
			throws RetrievalFailureSystemException {		
		return queryDao.queryForList(query, clazz);
	}



	@Override
	public <E> List<E> queryForList(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException {
		return queryDao.queryForList(query, args, clazz);
	}



	@Override
	public <E> List<E> queryForList(String query, RowMapper<E> mapper)
			throws RetrievalFailureSystemException {
		return queryDao.queryForList(query, mapper);
	}



	@Override
	public <E> List<E> queryForList(String query, Object[] args,
			RowMapper<E> mapper) throws RetrievalFailureSystemException {
		return queryDao.queryForList(query, args, mapper);
	}



	@Override
	public <E> List<E> queryForBeanList(String query, Object[] args,
			Class<E> clazz) throws RetrievalFailureSystemException {
		return queryDao.queryForBeanList(query, args, clazz);
	}



	@Override
	public <E> E queryForBean(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException {
		return queryDao.queryForBean(query, args, clazz);
	}



	@Override
	public <E> E queryForObject(String query, Object[] args, Class<E> clazz)
			throws RetrievalFailureSystemException {
		return queryDao.queryForObject(query, args, clazz);
	}



	@Override
	public <E> E queryForObject(String query, RowMapper<E> mapper)
			throws RetrievalFailureSystemException {
		return queryDao.queryForObject(query, mapper);
	}



	@Override
	public <E> E queryForObject(String query, Object[] args, RowMapper<E> mapper)
			throws RetrievalFailureSystemException {
		return queryDao.queryForObject(query, args, mapper);
	}



	@Override
	public Map<String, Object> queryForMap(String query, Object[] args)
			throws RetrievalFailureSystemException {
		return queryDao.queryForMap(query, args);
	}



	@Override
	public List<Map<String, Object>> queryForList(String query)
			throws RetrievalFailureSystemException {
		return queryDao.queryForList(query);
	}



	@Override
	public List<Map<String, Object>> queryForList(String query, Object[] args)
			throws RetrievalFailureSystemException {
		return queryDao.queryForList(query, args);
	}
		
}
