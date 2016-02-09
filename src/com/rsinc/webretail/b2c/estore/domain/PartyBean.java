/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Roshan Titus 
 *
 */
public class PartyBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6462474650349080734L;

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phone;
	private AddressBean partyAddress;
	private String gender;
	private Date dateOfBirth;
	
	/**
	 * 
	 */
	public PartyBean() {
		// TODO Auto-generated constructor stub
	}

	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "party_id")
	public Long getPartyId() {
		return id;
	}

	public void setPartyId(Long id) {
		this.id = id;
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AddressBean getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(AddressBean partyAddress) {
		this.partyAddress = partyAddress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	
}
