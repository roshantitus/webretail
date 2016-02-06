/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager;

import static junit.framework.Assert.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.domain.UserBean;
import com.rsinc.webretail.b2c.estore.domain.enums.UserStatus;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserEntityManagerTest {

	@Autowired
	private UserEntityManager userEntityManager;
	
			
	@Test
	@Transactional
	public void testCreateUserInTransaction()
	{
		try {
			UserBean userBean = userEntityManager.create(getUser());
			
			assertNotNull(userBean.getUserId());
			System.out.println(userBean.getUserId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testCreateUserWithoutTransaction()
	{
		try {
			
			userEntityManager.create(getUser());
			
			fail("create() should be called in a transaction context");
			

		} catch (Exception e) {
			assertTrue(e instanceof org.springframework.transaction.IllegalTransactionStateException);
			assertEquals(e.getMessage(), "No existing transaction found for transaction marked with propagation 'mandatory'");
		}
	}	
	
//	@Test
//	@Transactional
//	public void testUpdateUserInTransaction()
//	{
//		try {
//			UserBean userBean = userEntityManager.
//			userBean.setStatus(UserStatus.ACTIVE.toString());
//			userEntityManager.update(userBean);
//			
//			assertEquals(userBean.getStatus(), UserStatus.ACTIVE);
//			System.out.println(userBean.getStatus());
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//	}
	
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		return userBean;
	}	
}
