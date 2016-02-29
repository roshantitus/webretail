/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager.impl;

import java.util.Calendar;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.data.entity.enums.OrderStatus;
import com.rsinc.webretail.b2c.estore.data.entity.manager.OrderEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OrderEntityManagerImpl extends BaseEntityManagerImpl<OrderBean> implements OrderEntityManager {

	
	@Override
	public void setDefaultValues(OrderBean orderBean) {
		
		if(null == orderBean.getOrderDate())
		{		
			orderBean.setOrderDate(Calendar.getInstance());
		}
		
		if(null == orderBean.getOrderStatus())
		{
			orderBean.setOrderStatus(OrderStatus.NEW.toString());
		}	
		super.setDefaultValues(orderBean);
	}


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id) throws PersistanceFailureSystemException,
			RecordNotFoundException, ValidationException {
		deleteById(OrderBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public OrderBean loadById(Object id)
			throws RetrievalFailureSystemException, RecordNotFoundException,
			ValidationException {
		return load(OrderBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<OrderBean> findAll() throws RetrievalFailureSystemException {
		return getPersistanceDao().findAll(OrderBean.class);
	}


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.OrderEntityManager#findOrdersByStatus(java.util.List)
	 */
	@Override
	public List<OrderBean> findOrdersByStatus(List<OrderStatus> orderStatusList) {
		// TODO implement method functionality
		return null;
	}


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#findAll(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<OrderBean> findAll(ResultLoadCriteria resultLoadCriteria)
			throws RetrievalFailureSystemException {
		return getPersistanceDao().findAll(OrderBean.class, resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#getTotalRecordCount()
	 */
	@Override
	public Long getTotalRecordCount() throws RetrievalFailureSystemException {
		return getPersistanceDao().getTotalRecordCount(OrderBean.class);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.impl.BaseEntityManagerImpl#getTotalRecordCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalRecordCount(ResultLoadCriteria resultLoadCriteria)
			throws RetrievalFailureSystemException {
		return getPersistanceDao().getTotalRecordCount(OrderBean.class, resultLoadCriteria);
	}

}
