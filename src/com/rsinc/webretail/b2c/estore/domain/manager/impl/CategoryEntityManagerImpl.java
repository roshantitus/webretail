/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain.manager.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.rsinc.webretail.b2c.estore.data.dao.BaseDao;
import com.rsinc.webretail.b2c.estore.data.dao.CategoryDao;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.domain.manager.CategoryEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Component
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CategoryEntityManagerImpl extends BaseEntityManagerImpl<CategoryBean> implements CategoryEntityManager{

	@Inject
	private CategoryDao<CategoryBean> categoryDao;

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.BaseEntityManager#getDao()
	 */
	@Override
	public BaseDao<CategoryBean> getDao() {
		// TODO implement method functionality
		return categoryDao;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#deleteById(java.lang.Object)
	 */
	@Override
	public void deleteById(Object id) {
		deleteById(CategoryBean.class, id);
		
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#loadById(java.lang.Object)
	 */
	@Override
	public CategoryBean loadById(Object id) {
		// TODO implement method functionality
		return load(CategoryBean.class, id);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.domain.manager.impl.BaseEntityManagerImpl#findAll()
	 */
	@Override
	public List<CategoryBean> findAll() {
		// TODO implement method functionality
		return getDao().findAll(CategoryBean.class);
	}

	
	
}
