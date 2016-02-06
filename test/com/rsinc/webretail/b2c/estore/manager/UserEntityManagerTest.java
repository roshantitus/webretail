/**
 * 
 */
package com.rsinc.webretail.b2c.estore.manager;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

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
	//Execute method without transaction
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
	
	@Test
	@Transactional
	public void testCreateUser()
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
	@Transactional
	public void testLoadUser()
	{
		try {
			UserBean userBean = userEntityManager.create(getUser());
			assertNotNull(userEntityManager.loadById(userBean.getUserId()));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	public void testUpdateUser()
	{
		try {
			//Create a new user
			Long userId = userEntityManager.create(getUser()).getUserId();
			
			//Find the user and assert status
			UserBean userBean = userEntityManager.loadById(userId);
			assertEquals(userBean.getStatus(), UserStatus.NEW.toString());
			
			//Update the status
			userBean.setStatus(UserStatus.ACTIVE.toString());			
			userEntityManager.update(userBean);
			
			//fetch the user again and check status
			assertEquals(userEntityManager.loadById(userId).getStatus(), UserStatus.ACTIVE.toString());
			System.out.println(userBean.getStatus());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	public void testDeleteUser()
	{
		try {
			//Create a new user
			Long userId = userEntityManager.create(getUser()).getUserId();
			
			//Check whether the user exists
			UserBean user = userEntityManager.loadById(userId);
			assertNotNull(user);
			
			//delete the user by id
			userEntityManager.delete(user);
			
			assertTrue(null == userEntityManager.loadById(userId));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
	@Test
	@Transactional
	public void testDeleteUserById()
	{
		try {
			//Create a new user
			Long userId = userEntityManager.create(getUser()).getUserId();
			
			//Check whether the user exists
			assertNotNull(userEntityManager.loadById(userId));
			
			//delete the user by id
			userEntityManager.deleteById(userId);
			
			assertTrue(null == userEntityManager.loadById(userId));
			
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
