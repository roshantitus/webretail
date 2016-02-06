/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.domain.UserBean;

import static junit.framework.Assert.*;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
public class GenericDaoTest {

	@Autowired
	private UserDao<UserBean> userDao;
	
	@Test
	public void testCreateUser()
	{
		try {
			UserBean userBean = getUser();
			userDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			System.out.println(userBean.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	/**
	 * @return
	 */
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		userBean.setStatus("NEW");
		userBean.setLocaleCode("en_US");
		return userBean;
	}
}
