/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.manager.CategoryEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CategoryEntityManagerImpl extends BaseEntityManagerImpl<CategoryBean> implements CategoryEntityManager{

	
	@Override
	public void setDefaultValues(CategoryBean baseBean) {
		// TODO implement method functionality
		super.setDefaultValues(baseBean);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id)  throws PersistanceFailureSystemException, RecordNotFoundException, ValidationException{
		deleteById(CategoryBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public CategoryBean loadById(Object id)  throws RetrievalFailureSystemException, RecordNotFoundException, ValidationException{
		// TODO implement method functionality
		return load(CategoryBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<CategoryBean> findAll()  throws RetrievalFailureSystemException{
		// TODO implement method functionality
		return getPersistanceDao().findAll(CategoryBean.class);
	}

	
	
}
