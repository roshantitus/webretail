/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.common.config.AppConfig;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class EStoreAdminServiceTest {
	

	@Inject
	private EStoreAdminService eStoreAdminService;	
	
	@Test
	//@Transactional
	public void testCategory()
	{
		try {
			Category category = getCategory();
			Long categoryId = eStoreAdminService.addCategory(category);
			
			Category categoryFromDB = eStoreAdminService.getCategory(categoryId);
			
			assertNotNull(categoryFromDB);
			assertNotNull(categoryFromDB.getCategoryId());
			assertEquals(categoryId, categoryId);
			assertNotNull(categoryFromDB.getCategoryName());
			assertEquals("Books", categoryFromDB.getCategoryName());
			assertNotNull(categoryFromDB.getCategoryDescription());
			assertEquals("Collection of classic and non-classic books", categoryFromDB.getCategoryDescription());
			
			List<Category> categoryList = eStoreAdminService.getAllCategories();
			assertEquals(categoryList.size(), 1);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}	
	
	private Category getCategory() {
		Category category = new Category();
		category.setCategoryName("Books");
		category.setCategoryDescription("Collection of classic and non-classic books");
		return category;
	}	

}
