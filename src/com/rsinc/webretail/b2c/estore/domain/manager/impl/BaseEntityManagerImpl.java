/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

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
import com.rsinc.webretail.b2c.estore.domain.manager.BaseEntityManager;

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



	@Override
	public PersistanceDao<T> getPersistanceDao() {
		return persistanceDao;
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
	public T load(Class<T> type, Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException{
		
		validateForId(id);		
		return getPersistanceDao().find(type, id);
	}

	public abstract T loadById(Object id) throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException;

	@Override
	public abstract List<T> findAll() throws RetrievalFailureSystemException;

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
		
}
