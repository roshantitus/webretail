/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.util.EntityConversionUtils;
import com.rsinc.webretail.b2c.estore.domain.manager.UserEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public class EStoreAdminServiceImpl extends BaseEStoreServiceImpl implements EStoreAdminService {

	@Autowired
	private UserEntityManager userEntityManager;
	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {

		return EntityConversionUtils.convertUserBean2User(getUserEntityManager().findAll());
	}


	public UserEntityManager getUserEntityManager() {
		return userEntityManager;
	}
	
	
	
}
