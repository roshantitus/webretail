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
@Table(name="VISITOR")
public class VisitorBean extends BaseBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3680712075643452099L;

	public VisitorBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "visitor_id")
	public Long getVisitorId() {
		return id;
	}	
	
	public void setVisitorId(Long id) {
		this.id = id;
	}		
}
