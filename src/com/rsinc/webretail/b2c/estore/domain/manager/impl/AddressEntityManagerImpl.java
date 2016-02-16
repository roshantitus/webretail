/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.BeanValidationException;
import com.rsinc.webretail.b2c.estore.data.dao.AddressDao;
import com.rsinc.webretail.b2c.estore.data.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.data.entity.AddressBean;
import com.rsinc.webretail.b2c.estore.domain.manager.AddressEntityManager;

/**O
 * @author Roshan Titus 
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AddressEntityManagerImpl extends BaseEntityManagerImpl<AddressBean> implements AddressEntityManager {

	/**
	 * 
	 */
	@Inject
	private AddressDao<AddressBean> addressDao;
	
	public AddressEntityManagerImpl() {
	}
	
	@Override
	public void setDefaultValues(AddressBean addressBean) {
	
		super.setDefaultValues(addressBean);
	}

	@Override
	public void validateForCreate(AddressBean addressBean) throws BeanValidationException {
		if(null == addressBean)
		{
			throw new IllegalArgumentException("AddressBean object cannot be null"); 
		}			
		super.validateForCreate(addressBean);
	}

	@Override
	public BaseDao<AddressBean> getDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao<AddressBean> addressDao) {
		this.addressDao = addressDao;
	}
	
	@Override
	public AddressBean loadById(Object id){

		return load(AddressBean.class, id);
	}

	@Override
	public void deleteById(Object id){
		
		deleteById(AddressBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<AddressBean> findAll() {
		return getDao().findAll(AddressBean.class);
	}
}
