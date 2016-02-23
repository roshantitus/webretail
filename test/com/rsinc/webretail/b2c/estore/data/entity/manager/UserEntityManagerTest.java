/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.IllegalTransactionStateException;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.data.entity.AddressBean;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;
import com.rsinc.webretail.b2c.estore.data.entity.enums.UserStatus;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserEntityManagerTest {

	/**
	 * 
	 */
	private static final String PARTY_ADDRESS_STATE = "Kerala";
	private static final String PARTY_ADDRESS_STATE_NEW = "Karnataka";
	/**
	 * 
	 */
	private static final String PARTY_EMAIL_ID = "roshantitus@gmail.com";
	private static final String PARTY_EMAIL_ID_NEW = "susankoruthu@gmail.com";
	
	private static Logger logger = LoggerFactory.getLogger(UserEntityManagerTest.class);
	
	@Inject
	private UserEntityManager userEntityManager;
		
	@Inject
	private PartyEntityManager partyEntityManager;
	
	@Inject
	private AddressEntityManager addressEntityManager;	
	
	@Test
	//Execute method without transaction
	public void testCreateUserWithoutTransaction()
	{
		try {
			
			userEntityManager.create(getUser());
			
			fail("create() should be called in a transaction context");
			

		} catch (IllegalTransactionStateException e) {
			assertEquals(e.getMessage(), "No existing transaction found for transaction marked with propagation 'mandatory'");
		}
		catch(Exception e)
		{
			fail("Error while creating user");
		}
	}
	
	@Test
	@Transactional
	public void testCreateUser()
	{
		try {
			UserBean userBean = userEntityManager.create(getUser());
			
			assertNotNull(userBean.getUserId());
			assertNotNull(userBean.getParty());
			assertNotNull(userBean.getParty().getPartyId());
			assertNotNull(userBean.getParty().getPartyAddress());
			assertNotNull(userBean.getParty().getPartyAddress().getAddressId());
			
			Long userId = userBean.getUserId();
			UserBean userBeanFromDB = userEntityManager.loadById(userId);
			assertNotNull(userBeanFromDB);
			
			Long partyId = userBean.getParty().getPartyId();			
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			Long addressId = userBean.getParty().getPartyAddress().getAddressId();
			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
			assertNotNull(partyAddressBeanFromDB);
			
			logger.info("userBean.getUserId():" + userBeanFromDB.getUserId());
			logger.info("userBean.getParty().getPartyId():" + userBeanFromDB.getParty().getPartyId());
			logger.info("userBean.getParty().getPartyAddress().getAddressId():" + userBeanFromDB.getParty().getPartyAddress().getAddressId());
			
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
			UserBean userBeanFromDB = userEntityManager.loadById((userEntityManager.create(getUser())).getUserId());
			assertNotNull(userBeanFromDB);
			assertNotNull(userBeanFromDB.getUserId());
			assertNotNull(userBeanFromDB.getParty());
			assertNotNull(userBeanFromDB.getParty().getPartyId());
			assertNotNull(userBeanFromDB.getParty().getPartyAddress());
			assertNotNull(userBeanFromDB.getParty().getPartyAddress().getAddressId());			
			
			Long partyId = userBeanFromDB.getParty().getPartyId();			
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			Long addressId = userBeanFromDB.getParty().getPartyAddress().getAddressId();
			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
			assertNotNull(partyAddressBeanFromDB);
			
			logger.info("userBean.getUserId():" + userBeanFromDB.getUserId());
			logger.info("userBean.getParty().getPartyId():" + userBeanFromDB.getParty().getPartyId());	
			logger.info("userBean.getParty().getPartyAddress().getAddressId():" + userBeanFromDB.getParty().getPartyAddress().getAddressId());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	public void testFindAllUsers()
	{
		try {
			UserBean userBeanFromDB1 = userEntityManager.loadById((userEntityManager.create(getUser())).getUserId());
			assertNotNull(userBeanFromDB1);
			assertNotNull(userBeanFromDB1.getUserId());
			assertNotNull(userBeanFromDB1.getParty());
			assertNotNull(userBeanFromDB1.getParty().getPartyId());
			assertNotNull(userBeanFromDB1.getParty().getPartyAddress());
			assertNotNull(userBeanFromDB1.getParty().getPartyAddress().getAddressId());	
			
			UserBean userBeanFromDB2 = userEntityManager.loadById((userEntityManager.create(getUserWithoutPartyAddress())).getUserId());
			assertNotNull(userBeanFromDB2);
			assertNotNull(userBeanFromDB2.getUserId());
			assertNotNull(userBeanFromDB2.getParty());
			assertNotNull(userBeanFromDB2.getParty().getPartyId());
			
			List<UserBean> userBeanList = userEntityManager.findAll();
			assertEquals(userBeanList.size(), 2);
			
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
			UserBean userBeanFromDB = userEntityManager.loadById(userId);
			assertNotNull(userBeanFromDB);
			assertNotNull(userBeanFromDB.getParty());			
			assertEquals(userBeanFromDB.getStatus(), UserStatus.NEW.toString());
			assertEquals(userBeanFromDB.getParty().getEmail(), PARTY_EMAIL_ID);
			assertEquals(userBeanFromDB.getParty().getPartyAddress().getState(), PARTY_ADDRESS_STATE);
			
			Long partyId = userBeanFromDB.getParty().getPartyId();
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			Long addressId = userBeanFromDB.getParty().getPartyAddress().getAddressId();
			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
			assertNotNull(partyAddressBeanFromDB);
			
			//Update the fields
			userBeanFromDB.setStatus(UserStatus.ACTIVE.toString());
			userBeanFromDB.getParty().setEmail(PARTY_EMAIL_ID_NEW);
			userBeanFromDB.getParty().getPartyAddress().setState(PARTY_ADDRESS_STATE_NEW);
			userEntityManager.update(userBeanFromDB);
			
			//fetch the user again and check status
			UserBean userBeanFromDBAfterUpdate = userEntityManager.loadById(userId);
			assertNotNull(userBeanFromDBAfterUpdate);
			assertNotNull(userBeanFromDBAfterUpdate.getParty());
			assertEquals(userBeanFromDBAfterUpdate.getStatus(), UserStatus.ACTIVE.toString());
			assertEquals(userBeanFromDBAfterUpdate.getParty().getEmail(), PARTY_EMAIL_ID_NEW);
			assertEquals(userBeanFromDBAfterUpdate.getParty().getPartyAddress().getState(), PARTY_ADDRESS_STATE_NEW);
			
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
			UserBean userBeanFromDB = userEntityManager.loadById(userId);
			assertNotNull(userBeanFromDB);
			assertNotNull(userBeanFromDB.getParty());
			
			Long partyId = userBeanFromDB.getParty().getPartyId();			
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			Long addressId = userBeanFromDB.getParty().getPartyAddress().getAddressId();
			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
			assertNotNull(partyAddressBeanFromDB);
			
			//delete the user
			userEntityManager.delete(userBeanFromDB);
			
			try {
				userEntityManager.loadById(userId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}			
			
			
			try {
				partyEntityManager.loadById(partyId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}	
			
			
			try {
				addressEntityManager.loadById(addressId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}
			
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
			UserBean userBeanFromDB = userEntityManager.loadById(userId);
			assertNotNull(userBeanFromDB);
			assertNotNull(userBeanFromDB.getParty());
			
			Long partyId = userBeanFromDB.getParty().getPartyId();			
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			Long addressId = userBeanFromDB.getParty().getPartyAddress().getAddressId();
			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
			assertNotNull(partyAddressBeanFromDB);
			
			//delete the user by id
			userEntityManager.deleteById(userId);
			
			try {
				userEntityManager.loadById(userId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}			
			
			
			try {
				partyEntityManager.loadById(partyId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}	
			
			
			try {
				addressEntityManager.loadById(addressId);
				fail("Should have thrown exception");
			} catch (RecordNotFoundException e) {
				
			} catch (RetrievalFailureSystemException e) {
				fail("Error whil Deleting user");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}		
	
	@Test
	@Transactional
	public void testCreateUserWithoutParty()
	{
		try {
			userEntityManager.create(getUserWithoutParty());
		} catch (Exception e) {
			assertTrue(e instanceof java.lang.IllegalArgumentException);
			assertEquals(e.getMessage(), "Party object cannot be null");
		}
	}	
	
	@Test
	@Transactional
	public void testCreateUserWithoutPartyAddress()
	{
		try {
			UserBean userBean = userEntityManager.create(getUserWithoutPartyAddress());
			
			assertNotNull(userBean.getUserId());
			assertNotNull(userBean.getParty());
			assertNotNull(userBean.getParty().getPartyId());
			
			Long partyId = userBean.getParty().getPartyId();			
			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
			assertNotNull(partyBeanFromDB);
			
			logger.info("userBean.getUserId():" + userBean.getUserId());
			logger.info("userBean.getParty().getPartyId():" + userBean.getParty().getPartyId());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
//	@Test
//	@Transactional
//	public void testSetDefaultValues()
//	{
//		try {
//			UserBean userBeanFromDB = userEntityManager.loadById((userEntityManager.create(getUser())).getUserId());
//			assertNotNull(userBeanFromDB);
//			assertNotNull(userBeanFromDB.getUserId());
//			assertNotNull(userBeanFromDB.getParty());
//			assertNotNull(userBeanFromDB.getParty().getPartyId());
//			assertNotNull(userBeanFromDB.getParty().getPartyAddress());
//			assertNotNull(userBeanFromDB.getParty().getPartyAddress().getAddressId());			
//			
//			Long partyId = userBeanFromDB.getParty().getPartyId();			
//			PartyBean partyBeanFromDB = partyEntityManager.loadById(partyId);
//			assertNotNull(partyBeanFromDB);
//			
//			Long addressId = userBeanFromDB.getParty().getPartyAddress().getAddressId();
//			AddressBean partyAddressBeanFromDB = addressEntityManager.loadById(addressId);
//			assertNotNull(partyAddressBeanFromDB);
//			
//			logger.info("userBean.getUserId():" + userBeanFromDB.getUserId());
//			logger.info("userBean.getParty().getPartyId():" + userBeanFromDB.getParty().getPartyId());	
//			logger.info("userBean.getParty().getPartyAddress().getAddressId():" + userBeanFromDB.getParty().getPartyAddress().getAddressId());
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//	}	
	
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		PartyBean party = new PartyBean();
		party.setEmail(PARTY_EMAIL_ID);
		AddressBean partyAddress = new AddressBean();
		partyAddress.setState(PARTY_ADDRESS_STATE);
		party.setPartyAddress(partyAddress);
		userBean.setParty(party);
		return userBean;
	}
	
	private UserBean getUserWithoutPartyAddress() {
		UserBean userBean = new UserBean();
		PartyBean party = new PartyBean();
		party.setEmail(PARTY_EMAIL_ID);
		userBean.setParty(party);
		return userBean;
	}
	
	private UserBean getUserWithoutParty() {
		UserBean userBean = new UserBean();
		return userBean;
	}	
}
