/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.util.EntityConversionUtils;
import com.rsinc.webretail.b2c.estore.data.entity.manager.UserEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public class EStoreAdminServiceImpl extends BaseEStoreServiceImpl implements EStoreAdminService {

	@Inject
	private UserEntityManager userEntityManager;
	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() throws ApplicationException, SystemException{

		return EntityConversionUtils.convertUserBean2User(getUserEntityManager().findAll());
	}


	public UserEntityManager getUserEntityManager() {
		return userEntityManager;
	}
	
	
	
}
