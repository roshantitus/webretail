/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.config.AppConfig;
import com.rsinc.webretail.b2c.estore.config.DatabaseConfig;

import junit.framework.Assert;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class, DatabaseConfig.class})
public class UserDaoTest {

	@Test
	public void testDummy()
	{
		Assert.fail("Not implemented!");
	}
}
