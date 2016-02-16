/**
 * 
 */
package com.rsinc.webretail.b2c.estore.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
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
@Access(AccessType.PROPERTY)
//@NamedQueries({@NamedQuery(name="findByUsername", query=""), })
@Table(name="USER")
public class UserBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -438375391659822777L;
	

	private PartyBean party;
//	private AuthenticationBean authentication;
	private String status;
	private String localeCode;
//	private List<RoleBean> roles;
//	private AddressBean billingAddress;
//	private AddressBean deliveryAddress;
	private Integer rewardPoints;
	private Boolean subscribedForNewsLetterYN;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Long getUserId() {
		return id;
	}

	public void setUserId(Long id) {
		this.id = id;
	}
	
	@OneToOne(optional=false, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="PARTY_ID", unique=true, nullable=false, updatable=true)	
	public PartyBean getParty() {
		return party;
	}

	public void setParty(PartyBean party) {
		this.party = party;
	}

//	public AuthenticationBean getAuthentication() {
//		return authentication;
//	}
//
//	public void setAuthentication(AuthenticationBean authentication) {
//		this.authentication = authentication;
//	}

	@Column(name = "status")	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "locale_code")	
	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

//	public List<RoleBean> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<RoleBean> roles) {
//		this.roles = roles;
//	}
//
//	public AddressBean getBillingAddress() {
//		return billingAddress;
//	}
//
//	public void setBillingAddress(AddressBean billingAddress) {
//		this.billingAddress = billingAddress;
//	}
//
//	public AddressBean getDeliveryAddress() {
//		return deliveryAddress;
//	}
//
//	public void setDeliveryAddress(AddressBean deliveryAddress) {
//		this.deliveryAddress = deliveryAddress;
//	}

	@Column(name = "reward_points")	
	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Column(name = "subscribed_for_news_letter_yn")	
	public Boolean getSubscribedForNewsLetterYN() {
		return subscribedForNewsLetterYN;
	}

	public void setSubscribedForNewsLetterYN(Boolean subscribedForNewsLetterYN) {
		this.subscribedForNewsLetterYN = subscribedForNewsLetterYN;
	}

//	@Transient
//	public String getEmail() {
//		return party.getEmail();
//	}
//
//	public void setEmail(String email) {
//		this.party.setEmail(email);
//	}	
}
