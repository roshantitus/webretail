/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.dao.PartyDao;
import com.rsinc.webretail.b2c.estore.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.exception.BeanValidationException;
import com.rsinc.webretail.b2c.estore.manager.AddressEntityManager;
import com.rsinc.webretail.b2c.estore.manager.PartyEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PartyEntityManagerImpl extends BaseEntityManagerImpl<PartyBean> implements PartyEntityManager{

	@Inject
	private PartyDao<PartyBean> partyDao;
	
	@Inject
	private AddressEntityManager addressEntityManager;
	
	@Override
	public void setDefaultValues(PartyBean partyBean) {
		
		if(null != partyBean.getPartyAddress())
		{
			addressEntityManager.setDefaultValues(partyBean.getPartyAddress());
		}
		super.setDefaultValues(partyBean);
	}
	
	@Override
	public void validateForCreate(PartyBean partyBean) throws BeanValidationException {
		if(null == partyBean)
		{
			throw new IllegalArgumentException("Party object cannot be null"); 
		}
		if(null != partyBean.getPartyAddress())
		{
			addressEntityManager.validateForCreate(partyBean.getPartyAddress());
		}
		super.validateForCreate(partyBean);
	}	
	
	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.manager.impl.BaseEntityManagerImpl#getDao()
	 */
	@Override
	public BaseDao<PartyBean> getDao() {
		return partyDao;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id) {
		deleteById(PartyBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public PartyBean loadById(Object id) {
		return load(PartyBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<PartyBean> findAll() {
		return getDao().findAll(PartyBean.class);
	}

}
