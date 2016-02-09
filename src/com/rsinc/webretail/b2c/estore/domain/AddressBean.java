/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Roshan Titus 
 *
 */
public class AddressBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2647795244020563453L;

	private String addressLine1;
	private String addressLine2;
	private String landmark;
	private String city;
	private String zipCode;
	private String state;
	private String country;
	
	/**
	 * 
	 */
	public AddressBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "address_id")
	public Long getAddressId() {
		return id;
	}

	public void setAddressId(Long id) {
		this.id = id;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getLandmark() {
		return landmark;
	}


	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}	

	
}
