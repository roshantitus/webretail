/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.domain.UserBean;

import junit.framework.Assert;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserDaoTest {

	@Autowired
	private UserDao<UserBean> userDao;
	
	@Test
	public void testCreate()
	{
		UserBean userBean = getUser();
		userDao.create(userBean);
	}

	/**
	 * @return
	 */
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		return userBean;
	}
}
