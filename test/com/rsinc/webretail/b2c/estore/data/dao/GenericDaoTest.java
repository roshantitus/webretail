/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.dao;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.util.Constants;
import com.rsinc.webretail.b2c.estore.common.util.SecurityContextUtils;
import com.rsinc.webretail.b2c.estore.data.dao.UserDao;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@Transactional
public class GenericDaoTest {
	
	private static final String PARTY_EMAIL_ID = "roshantitus@gmail.com";

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
