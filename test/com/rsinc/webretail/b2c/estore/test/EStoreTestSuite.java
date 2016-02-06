/**
 * 
 */
package com.rsinc.webretail.b2c.estore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rsinc.webretail.b2c.estore.dao.GenericDaoTest;
import com.rsinc.webretail.b2c.estore.manager.UserEntityManagerTest;

/**
 * @author Roshan Titus
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	GenericDaoTest.class,
	UserEntityManagerTest.class
})
public class EStoreTestSuite {

}
