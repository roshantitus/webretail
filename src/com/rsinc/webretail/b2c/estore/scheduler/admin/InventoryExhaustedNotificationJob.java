/**
 * 
 */
package com.rsinc.webretail.b2c.estore.scheduler.admin;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Roshan Titus
 *
 */
public class InventoryExhaustedNotificationJob {

	/**
	 * 
	 */
	public InventoryExhaustedNotificationJob() {
		// TODO initialize object
	}
	
	@Scheduled(cron="*/2 * * * * MON-FRI")
	public void notifyInventoryChangeToAdmn()
	{
		
	}

}
