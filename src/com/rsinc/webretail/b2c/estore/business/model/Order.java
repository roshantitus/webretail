/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.model;

import java.util.Calendar;

/**
 * @author Roshan Titus
 *
 */
public class Order {

	private Long orderId;
	private Calendar orderDate;
	private String orderStatus;
	
	public Order() {
		super();
		// TODO initialize object
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Calendar getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
