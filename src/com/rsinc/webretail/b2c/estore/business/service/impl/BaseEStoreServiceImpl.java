/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import javax.inject.Inject;

import com.rsinc.webretail.b2c.estore.business.service.EStoreService;
import com.rsinc.webretail.b2c.estore.data.entity.manager.CategoryEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.OrderEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.ProductEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.UserEntityManager;

/**
 * @author Roshan Titus
 *
 */
public abstract class BaseEStoreServiceImpl implements EStoreService {

	@Inject
	private UserEntityManager userEntityManager;
	
	@Inject
	private CategoryEntityManager categoryEntityManager;
	
	@Inject
	private ProductEntityManager productEntityManager;
	
	@Inject
	private OrderEntityManager orderEntityManager;	

	
	protected UserEntityManager getUserEntityManager() {
		return userEntityManager;
	}	
	

	protected CategoryEntityManager getCategoryEntityManager() {
		return categoryEntityManager;
	}


	protected ProductEntityManager getProductEntityManager() {
		return productEntityManager;
	}


	protected OrderEntityManager getOrderEntityManager() {
		return orderEntityManager;
	}


}
