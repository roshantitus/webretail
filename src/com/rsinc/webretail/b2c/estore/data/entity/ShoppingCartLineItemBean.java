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
@Table(name="CART_LINE_ITEM")
public class ShoppingCartLineItemBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 984909181985504238L;

	public ShoppingCartLineItemBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "cart_line_item_id")
	public Long getShoppingCartLineItemId() {
		return id;
	}	
	
	public void setShoppingCartLineItemId(Long id) {
		this.id = id;
	}	
}
