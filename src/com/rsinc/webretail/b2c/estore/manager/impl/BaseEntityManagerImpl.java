/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager.impl;

import java.util.Date;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.domain.BaseBean;
import com.rsinc.webretail.b2c.estore.exception.BeanValidationException;
import com.rsinc.webretail.b2c.estore.manager.BaseEntityManager;
import com.rsinc.webretail.b2c.estore.util.Constants;
import com.rsinc.webretail.b2c.estore.util.SecurityUtils;

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
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}		
		setDefaultValues(baseBean);
		validateForCreate(baseBean);
		return getDao().create(baseBean);
	}

	@Override
	public T update(T baseBean) {
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}	
		validateForUpdate(baseBean);
		return (T)getDao().update(baseBean);
	}
	

	@Override
	public void delete(T baseBean) {
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}	
		validateForDelete(baseBean);
	}	

	@Override
	public void deleteById(Object id) {
		
	}	
	
	@Override
	public void setDefaultValues(T baseBean) {
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}			
		if(null == baseBean.getCreatedBy())
		{
			baseBean.setCreatedBy(SecurityUtils.getLoggedInUserId());
		}
		
		if(null == baseBean.getCreatedDate())
		{		
			baseBean.setCreatedDate(new Date());
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
			baseBean.setUpdatedBy(SecurityUtils.getLoggedInUserId());
		}
		
		if(null == baseBean.getUpdatedDate())
		{		
			baseBean.setUpdatedDate(new Date());
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
	}

	@Override
	public void validateForDelete(T baseBean) throws BeanValidationException{
		// TODO Auto-generated method stub
		if(null == baseBean)
		{
			throw new IllegalArgumentException("BaseBean object is null"); 
		}			
	}

}
