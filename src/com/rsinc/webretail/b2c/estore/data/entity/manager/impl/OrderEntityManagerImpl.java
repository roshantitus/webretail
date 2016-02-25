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
	 * @see com.rsinc.webretail.b2c.estore.data.entity.manager.OrderEntityManager#getPendingOrders()
	 */
	@Override
	public List<OrderBean> getPendingOrders() {
		// TODO implement method functionality
		return null;
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



}
