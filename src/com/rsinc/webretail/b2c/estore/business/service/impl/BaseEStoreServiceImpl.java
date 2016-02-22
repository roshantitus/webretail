/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.service.EStoreService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.util.EntityConversionUtils;
import com.rsinc.webretail.b2c.estore.domain.manager.CategoryEntityManager;

/**
 * @author Roshan Titus
 *
 */
public abstract class BaseEStoreServiceImpl implements EStoreService {

	@Autowired
	private CategoryEntityManager categoryEntityManager;
	

	public CategoryEntityManager getCategoryEntityManager() {
		return categoryEntityManager;
	}
	
	
	@Override
	public List<Category> getAllCategories()  throws ApplicationException, SystemException{
		return EntityConversionUtils.convertCategoryBean2Category(getCategoryEntityManager().findAll());
	}


}
