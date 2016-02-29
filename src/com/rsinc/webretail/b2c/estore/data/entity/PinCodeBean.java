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
@Table(name="PINCODE_MASTER")
public class PinCodeBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8276672771453458982L;

	public PinCodeBean() {
		super();
	}
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "pincode_id")
	public Long getPinCodeId() {
		return id;
	}	
	
	public void setPinCodeId(Long id) {
		this.id = id;
	}	
}
