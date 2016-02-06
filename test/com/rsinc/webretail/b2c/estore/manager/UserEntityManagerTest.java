/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.domain.UserBean;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
public class UserEntityManagerTest {

	@Autowired
	private UserEntityManager userEntityManager;
	
	@Test
	public void testCreateUser()
	{
		try {
			UserBean userBean = getUser();
			userEntityManager.create(userBean);
			
			assertNotNull(userBean.getUserId());
			System.out.println(userBean.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		return userBean;
	}	
}
