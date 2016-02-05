/**
 * 
 */
package com.rsinc.webretail.b2c.estore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.manager.UserEntityManager;
import com.rsinc.webretail.b2c.estore.service.EStoreAdminService;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public class EStoreAdminServiceImpl implements EStoreAdminService {

	@Autowired
	private UserEntityManager userEntityManager;
}
