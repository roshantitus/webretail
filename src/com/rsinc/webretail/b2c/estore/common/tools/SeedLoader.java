/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.tools;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordAlreadyExistsException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.PersistanceFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.manager.CategoryEntityManager;

/**
 * @author Roshan Titus
 *
 */

public class SeedLoader {

	private ApplicationContext context;
	
	
	public SeedLoader() {
		super();
		
		context = new AnnotationConfigApplicationContext(AppConfig.class);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SeedLoader seedLoader = new SeedLoader();
		seedLoader.loadSeedData();
	}

	/**
	 * 
	 */

	public void loadSeedData() {
		
		try {
			
			// Load Categories		
			loadCategories();
			
		} catch (PersistanceFailureSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RecordAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @throws PersistanceFailureSystemException
	 * @throws RecordAlreadyExistsException
	 * @throws ValidationException
	 */

	public void loadCategories() throws PersistanceFailureSystemException,
			RecordAlreadyExistsException, ValidationException {
		
		
		CategoryEntityManager categoryEntityManager = context.getBean(CategoryEntityManager.class);
		for(int i = 0; i< 1000; i++)
		{
			categoryEntityManager.create(getCategory(i));
		}
	}
	
	/**
	 * @return
	 */
	private CategoryBean getCategory(Integer index) {
		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setCategoryName("Category" + index);
		categoryBean.setCategoryDescription("Category" + index);
		return categoryBean;
	}	


}
