/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.email;

import static junit.framework.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rsinc.webretail.b2c.estore.common.config.AppConfig;
import com.rsinc.webretail.b2c.estore.common.email.MailManager;
import com.rsinc.webretail.b2c.estore.common.email.MailMessage;
import com.rsinc.webretail.b2c.estore.common.exception.system.EmailDeliveryFailureSystemException;

/**
 * @author Roshan Titus
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class MailManagerTest {

	/**
	 * 
	 */
    @Autowired
    MailManager mailManager;
	   
	public MailManagerTest() {


	}
	
	@Test
	public void testSendMessageWithPlainText()
	{	
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom("roshantitus@gmail.com");
			mailMessage.setMessage("This is a test");
			mailMessage.setTo("roshantitus@gmail.com");
			mailMessage.setType(MailMessage.Type.PLAIN);
			mailMessage.setSubject("testSendMessageWithPlainText");
			mailManager.sendMessage(mailMessage );
			
		} catch (EmailDeliveryFailureSystemException e) {
			
			e.printStackTrace();
			fail(e.getMessage());			
		}		
	}

}
