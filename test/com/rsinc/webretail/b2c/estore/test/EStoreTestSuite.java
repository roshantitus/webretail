/**
 * 
 */
package com.rsinc.webretail.b2c.estore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rsinc.webretail.b2c.estore.common.email.MailManagerTest;
import com.rsinc.webretail.b2c.estore.data.dao.GenericDaoTest;
import com.rsinc.webretail.b2c.estore.domain.manager.UserEntityManagerTest;

/**
 * @author Roshan Titus
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	GenericDaoTest.class,
	UserEntityManagerTest.class,
	MailManagerTest.class
})
public class EStoreTestSuite {

}
