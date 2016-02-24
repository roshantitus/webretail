/**
 * 
 */
package com.rsinc.webretail.b2c.estore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminServiceTest;
import com.rsinc.webretail.b2c.estore.common.email.MailManagerTest;
import com.rsinc.webretail.b2c.estore.data.dao.PersistanceDaoTest;
import com.rsinc.webretail.b2c.estore.data.dao.QueryDaoTest;
import com.rsinc.webretail.b2c.estore.data.entity.manager.CategoryEntityManagerTest;
import com.rsinc.webretail.b2c.estore.data.entity.manager.UserEntityManagerTest;

/**
 * @author Roshan Titus
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	PersistanceDaoTest.class,
	QueryDaoTest.class,
	UserEntityManagerTest.class,
	CategoryEntityManagerTest.class,
	MailManagerTest.class,
	EStoreAdminServiceTest.class
})
public class EStoreTestSuite {

}
