/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

import java.util.Calendar;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.common.util.SecurityContextUtils;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;
import com.rsinc.webretail.b2c.estore.data.entity.enums.UserStatus;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
public class QueryDaoTest {
	
	private static final String PARTY_EMAIL_ID = "roshantitus@gmail.com";
	
	//@InjectLogger 
	private static Logger logger = LoggerFactory.getLogger(QueryDaoTest.class);
	
	@Inject
	private PersistanceDao persistanceDao;
		
	@Inject
	private QueryDao queryDao;	

	@Test
	public void testQueryForString()
	{
		try {
			UserBean userBean = getUser();
			persistanceDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			logger.info(userBean.getUserId());

			String localeCode = queryDao.queryForObject("select locale_code from user where user_id = ?", new Object[]{userBean.getUserId()}, String.class);
			assertNotNull(localeCode);
			assertEquals(localeCode, Constants.DEFAULT_LOCALE);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testQueryForInteger()
	{
		try {
			UserBean userBean = getUser();
			persistanceDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			logger.info(userBean.getUserId());

			Integer rewardPoints = queryDao.queryForObject("select reward_points from user where user_id = ?", new Object[]{userBean.getUserId()}, Integer.class);
			assertNotNull(rewardPoints);
			assertEquals(rewardPoints, Constants.ZERO);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void testQueryForLong()
	{
		try {
			UserBean userBean = getUser();
			persistanceDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			logger.info(userBean.getUserId());

			Long partyId = queryDao.queryForObject("select party_id from user where user_id = ?", new Object[]{userBean.getUserId()}, Long.class);
			assertNotNull(partyId);
			assertTrue(partyId > 0);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void testQueryForBoolean()
	{
		try {
			UserBean userBean = getUser();
			persistanceDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			logger.info(userBean.getUserId());

			Boolean deletedYN = queryDao.queryForObject("select deleted_yn from user where user_id = ?", new Object[]{userBean.getUserId()}, Boolean.class);
			assertNotNull(deletedYN);
			assertEquals(deletedYN, Boolean.FALSE);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
	@Test
	public void testQueryForMap()
	{
		try {
			UserBean userBean = getUser();
			persistanceDao.create(userBean);
			
			assertNotNull(userBean.getUserId());
			logger.info(userBean.getUserId());

			Map<String, Object> userMap = queryDao.queryForMap("select * from user where user_id = ?", new Object[]{userBean.getUserId()});
			assertNotNull(userMap);
			assertEquals(userMap.get("user_id"), userBean.getUserId());
			assertEquals(userMap.get("status"), UserStatus.NEW.toString());
			assertEquals(userMap.get("deleted_yn"), Boolean.FALSE);
			assertEquals(userMap.get("reward_points"), Constants.ZERO);		
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}	
	
//	@Test
//	public void testQueryForBean()
//	{
//		try {
//			UserBean userBean = getUser();
//			persistanceDao.create(userBean);
//			
//			assertNotNull(userBean.getUserId());
//			logger.info(userBean.getUserId());
//
//			UserBean userBeanFromDB = queryDao.queryForBean("select * from user where user_id = ?", new Object[]{userBean.getUserId()}, UserBean.class);
//			assertNotNull(userBeanFromDB);
//			assertEquals(userBeanFromDB.getUserId(), userBean.getUserId());
//			assertEquals(userBeanFromDB.getStatus(), userBean.getStatus());
//			assertEquals(userBeanFromDB.getDeletedYN(), userBean.getDeletedYN());
//			assertEquals(userBeanFromDB.getRewardPoints(), userBean.getRewardPoints());		
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			fail(e.getMessage());
//		}
//	}		

	/**
	 * @return
	 */
	private UserBean getUser() {
		UserBean userBean = new UserBean();
		userBean.setStatus(UserStatus.NEW.toString());
		userBean.setLocaleCode(Constants.DEFAULT_LOCALE);
		userBean.setRewardPoints(Constants.ZERO);
		userBean.setCreatedBy(SecurityContextUtils.getLoggedInUserId());
		userBean.setCreatedDate(Calendar.getInstance());
		userBean.setUpdatedBy(SecurityContextUtils.getLoggedInUserId());
		userBean.setUpdatedDate(Calendar.getInstance());
		userBean.setRecordVersionNo(Constants.ZERO);
		userBean.setDeletedYN(Constants.False);
		PartyBean party = new PartyBean();
		party.setEmail(PARTY_EMAIL_ID);
		party.setCreatedBy(SecurityContextUtils.getLoggedInUserId());
		party.setCreatedDate(Calendar.getInstance());
		party.setUpdatedBy(SecurityContextUtils.getLoggedInUserId());
		party.setUpdatedDate(Calendar.getInstance());
		party.setRecordVersionNo(Constants.ZERO);
		party.setDeletedYN(Constants.False);		
		userBean.setParty(party);
		return userBean;
	}	

}
