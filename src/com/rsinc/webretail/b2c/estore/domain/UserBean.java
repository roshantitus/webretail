/**
 * 
 */
package com.rsinc.webretail.b2c.estore.domain;

import java.util.List;

import javax.persistence.Entity;


/**
 * @author Roshan Titus 
 *
 */
@Entity
public class UserBean extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -438375391659822777L;
	private PartyBean party;
	private AuthenticationBean authentication;
	private String status;
	private String locale;
	private List<RoleBean> roles;
	private AddressBean billingAddress;
	private AddressBean deliveryAddress;
	private Integer rewardPoints;
	private Boolean subscribedForNewsLetterYN;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartyBean getParty() {
		return party;
	}

	public void setParty(PartyBean party) {
		this.party = party;
	}

	public AuthenticationBean getAuthentication() {
		return authentication;
	}

	public void setAuthentication(AuthenticationBean authentication) {
		this.authentication = authentication;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public List<RoleBean> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleBean> roles) {
		this.roles = roles;
	}

	public AddressBean getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(AddressBean billingAddress) {
		this.billingAddress = billingAddress;
	}

	public AddressBean getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(AddressBean deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public Integer getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public Boolean getSubscribedForNewsLetterYN() {
		return subscribedForNewsLetterYN;
	}

	public void setSubscribedForNewsLetterYN(Boolean subscribedForNewsLetterYN) {
		this.subscribedForNewsLetterYN = subscribedForNewsLetterYN;
	}

	
}
