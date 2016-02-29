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
@Table(name="STATE_MASTER")
public class StateBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7192900547149715765L;

	public StateBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "state_id")
	public Long getStateId() {
		return id;
	}	
	
	public void setStateId(Long id) {
		this.id = id;
	}		
}
