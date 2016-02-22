/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.domain.manager.AddressEntityManager;
import com.rsinc.webretail.b2c.estore.domain.manager.PartyEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PartyEntityManagerImpl extends BaseEntityManagerImpl<PartyBean> implements PartyEntityManager{
	
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
	public void validateForCreate(PartyBean partyBean) throws ValidationException {
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
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id)  throws PersistanceFailureSystemException, RecordNotFoundException{
		deleteById(PartyBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public PartyBean loadById(Object id)  throws RetrievalFailureSystemException, RecordNotFoundException{
		return load(PartyBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<PartyBean> findAll()  throws RetrievalFailureSystemException{
		return getPersistanceDao().findAll(PartyBean.class);
	}

}
