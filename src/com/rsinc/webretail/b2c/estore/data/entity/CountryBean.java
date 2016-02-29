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
@Table(name="COUNTRY_MASTER")
public class CountryBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2517388502200288843L;

	public CountryBean() {
		super();
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "country_id")
	public Long getCountryId() {
		return id;
	}	
	
	public void setCountryId(Long id) {
		this.id = id;
	}		
}
