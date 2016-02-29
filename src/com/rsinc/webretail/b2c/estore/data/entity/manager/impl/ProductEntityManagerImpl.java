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
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
import com.rsinc.webretail.b2c.estore.data.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.data.entity.manager.ProductEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ProductEntityManagerImpl extends BaseEntityManagerImpl<ProductBean> implements ProductEntityManager {

	
	@Override
	public void setDefaultValues(ProductBean baseBean) {
		// TODO implement method functionality
		super.setDefaultValues(baseBean);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id) throws PersistanceFailureSystemException,
			RecordNotFoundException, ValidationException {
		deleteById(ProductBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public ProductBean loadById(Object id)
			throws RetrievalFailureSystemException, RecordNotFoundException,
			ValidationException {

		return load(ProductBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<ProductBean> findAll() throws RetrievalFailureSystemException {

		return getPersistanceDao().findAll(ProductBean.class);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#findAll(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<ProductBean> findAll(ResultLoadCriteria resultLoadCriteria)
			throws RetrievalFailureSystemException {
		
		return getPersistanceDao().findAll(ProductBean.class, resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#getTotalRecordCount()
	 */
	@Override
	public Long getTotalRecordCount() throws RetrievalFailureSystemException {
		return getPersistanceDao().getTotalRecordCount(ProductBean.class);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#getTotalRecordCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalRecordCount(ResultLoadCriteria resultLoadCriteria)
			throws RetrievalFailureSystemException {
		return getPersistanceDao().getTotalRecordCount(ProductBean.class, resultLoadCriteria);
	}
}
