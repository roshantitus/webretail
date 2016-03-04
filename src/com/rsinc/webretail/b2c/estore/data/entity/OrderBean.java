/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity;

import java.util.Calendar;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Roshan Titus
 *
 */
@Entity
@Access(AccessType.PROPERTY)
@NamedQueries({@NamedQuery(name="findOrdersByStatus", query="from OrderBean orderBean where orderBean.orderStatus IN :params"), 
	@NamedQuery(name="findOrderCountByStatus", query="select count(orderBean) from OrderBean orderBean where orderBean.orderStatus IN :params"), })
@Table(name="ORDER")
public class OrderBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7738171511465403764L;

	private Calendar orderDate;
	private String orderStatus;
	
	
	/**
	 * @return
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "order_id")	
	public Long getOrderId() {
		return id;
	}

	@Column(name = "order_date")	
	@Temporal(TemporalType.DATE)	
	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	@Column(name = "order_status")	
	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * @param orderId
	 */
	public void setOrderId(Long orderId) {
		this.id = orderId;
		
	}

}
