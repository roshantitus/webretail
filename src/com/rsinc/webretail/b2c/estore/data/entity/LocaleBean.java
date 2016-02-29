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
@Table(name="LOCALE_MASTER")
public class LocaleBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1612960104256612548L;

	public LocaleBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "locale_id")
	public Long getLocaleId() {
		return id;
	}	
	
	public void setLocaleId(Long id) {
		this.id = id;
	}		
}
