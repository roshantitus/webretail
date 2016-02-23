/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class CategoryEntityManagerTest {
	
	private static Logger logger = LoggerFactory.getLogger(CategoryEntityManagerTest.class);

	@Inject
	private CategoryEntityManager categoryEntityManager;
	
	@Test
	@Transactional
	public void testFindAllCatgories()
	{
		try {
			CategoryBean categoryBeanFromDB1 = getCategoryEntityManager().loadById((getCategoryEntityManager().create(getCategory())).getCategoryId());
			assertNotNull(categoryBeanFromDB1);
			assertNotNull(categoryBeanFromDB1.getCategoryId());
			assertNotNull(categoryBeanFromDB1.getCategoryName());
			assertNotNull(categoryBeanFromDB1.getCategoryDescription());

			logger.info("categoryBeanFromDB1.getCategoryId():" + categoryBeanFromDB1.getCategoryId());
			
			List<CategoryBean> categoryBeanList = getCategoryEntityManager().findAll();
			assertEquals(categoryBeanList.size(), 1);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}		
	}

	/**
	 * @return
	 */
	private CategoryBean getCategory() {
		CategoryBean categoryBean = new CategoryBean();
		categoryBean.setCategoryName("Books");
		categoryBean.setCategoryDescription("Collection of classic and non-classic books");
		return categoryBean;
	}

	public CategoryEntityManager getCategoryEntityManager() {
		return categoryEntityManager;
	}
	
	
}
