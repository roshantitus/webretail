/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Roshan Titus 
 *
 */
@Entity
@Table(name="PARTY")
public class PartyBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6462474650349080734L;

	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String homePhoneNumber;
	private String businessPhoneNumber;
	private String cellPhoneNumber;
	private AddressBean partyAddress;
	private String gender;
	private Date dateOfBirth;
//	private UserBean user;
	
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
	
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "middle_name")		
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(optional=true, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="ADDRESS_ID", unique=true, nullable=true, updatable=true)		
	public AddressBean getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(AddressBean partyAddress) {
		this.partyAddress = partyAddress;
	}
	
	@Column(name = "home_phone_number")
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	@Column(name = "business_phone_number")
	public String getBusinessPhoneNumber() {
		return businessPhoneNumber;
	}

	public void setBusinessPhoneNumber(String businessPhoneNumber) {
		this.businessPhoneNumber = businessPhoneNumber;
	}

	@Column(name = "cell_phone_number")
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "date_of_birth")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

//	@OneToOne(optional=false, mappedBy="party")
//	public UserBean getUser() {
//		return user;
//	}
//
//
//	public void setUser(UserBean user) {
//		this.user = user;
//	}

	
	
}
