/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.entity.UserBean;
import com.rsinc.webretail.b2c.estore.util.Constants;
import com.rsinc.webretail.b2c.estore.util.SecurityContextUtils;

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
		userBean.setCreatedDate(new Date());
		userBean.setUpdatedBy(SecurityContextUtils.getLoggedInUserId());
		userBean.setUpdatedDate(new Date());
		userBean.setRecordVersionNo(Constants.ZERO);
		userBean.setDeletedYN(Constants.False);
		PartyBean party = new PartyBean();
		party.setEmail(PARTY_EMAIL_ID);
		party.setCreatedBy(SecurityContextUtils.getLoggedInUserId());
		party.setCreatedDate(new Date());
		party.setUpdatedBy(SecurityContextUtils.getLoggedInUserId());
		party.setUpdatedDate(new Date());
		party.setRecordVersionNo(Constants.ZERO);
		party.setDeletedYN(Constants.False);		
		userBean.setParty(party);
		return userBean;
	}
}
