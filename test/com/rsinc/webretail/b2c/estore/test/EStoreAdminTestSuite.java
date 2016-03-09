/**
 * 
 */
package com.rsinc.webretail.b2c.estore.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminServiceTest;

/**
 * @author Roshan Titus
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
	CommonsTestSuite.class,
	EStoreAdminServiceTest.class
})
public class EStoreAdminTestSuite {

}
