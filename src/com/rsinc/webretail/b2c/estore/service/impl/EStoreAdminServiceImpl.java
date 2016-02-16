/**
 * 
 */
package com.rsinc.webretail.b2c.estore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.domain.User;
import com.rsinc.webretail.b2c.estore.manager.UserEntityManager;
import com.rsinc.webretail.b2c.estore.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.util.EntityConversionUtils;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public class EStoreAdminServiceImpl extends EStoreServiceImpl implements EStoreAdminService {

	@Autowired
	private UserEntityManager userEntityManager;
	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.service.EStoreAdminService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() {

		return EntityConversionUtils.convertUserBean2User(userEntityManager.findAll());
	}
	
}
