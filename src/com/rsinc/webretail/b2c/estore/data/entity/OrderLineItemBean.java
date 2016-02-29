/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Roshan Titus
 *
 */
@Entity
@Access(AccessType.PROPERTY)
//@NamedQueries({@NamedQuery(name="findByUsername", query=""), })
@Table(name="ORDER_LINE_ITEM")
public class OrderLineItemBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -766227934910041988L;

	public OrderLineItemBean() {
		super();
		// TODO initialize object
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "order_line_item_id")
	public Long getOrderLineItemId() {
		return id;
	}	
	
	public void setOrderLineItemId(Long id) {
		this.id = id;
	}	
}
