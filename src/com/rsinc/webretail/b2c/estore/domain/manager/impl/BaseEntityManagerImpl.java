/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.BeanValidationException;
import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.common.util.SecurityContextUtils;
import com.rsinc.webretail.b2c.estore.data.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.data.entity.BaseBean;
import com.rsinc.webretail.b2c.estore.domain.manager.BaseEntityManager;

/**
 * @author Roshan Titus 
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public abstract class BaseEntityManagerImpl <T extends BaseBean> implements BaseEntityManager <T> {

	/**
	 * 
	 */
	public BaseEntityManagerImpl() {
	}

	public abstract BaseDao<T> getDao();
	
	@Override
	public T create(T baseBean) {
		
		validateForCreate(baseBean);
		setDefaultValues(baseBean);		
		return getDao().create(baseBean);
	}

	@Override
	public T update(T baseBean) {
	
		validateForUpdate(baseBean);
		return (T)getDao().update(baseBean);
	}
	

	@Override
	public void delete(T baseBean) {

		validateForDelete(baseBean);
		getDao().delete(baseBean);
	}	

	public abstract void deleteById(Object id);
	
	@Override
	public void deleteById(Class<T> type, Object id){
		
		validateForId(id);
		getDao().delete(type, id);
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
	public void validateForCreate(T baseBean) throws BeanValidationException{
		// TODO validate and throw BeanValidationException
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object cannot be null"); 
		}	
	}
	
	@Override
	public void validateForUpdate(T baseBean) throws BeanValidationException{
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
	public void validateForDelete(T baseBean) throws BeanValidationException{
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
	
	private void validateForId(Object id) throws BeanValidationException{
		if(null == id)
		{
			throw new IllegalArgumentException("Id cannot be null for delete"); 
		}			
	}

	@Override
	public T load(Class<T> type, Object id){
		
		validateForId(id);		
		return getDao().find(type, id);
	}

	public abstract T loadById(Object id);

	@Override
	public abstract List<T> findAll();

	@Override
	public List<T> bulkCreate(List<T> entities) {
		for(T baseBean : entities)
		{
			validateForCreate(baseBean);
			setDefaultValues(baseBean);				
		}
		return getDao().bulkCreate(entities);
	}

	@Override
	public List<T> bulkUdate(List<T> entities) {
		for(T baseBean : entities)
		{
			validateForUpdate(baseBean);		
		}
		return getDao().bulkUdate(entities);
	}
		
}
