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
		// TODO implement method functionality
		return getDummyUserList();
	}


	/**
	 * @return
	 */
	private List<User> getDummyUserList() {
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setUserId(new Long(1));
		user.setEmail("rt@gmail.com");
		users.add(user);
		return users;
	}	
}
