/**
 * 
 */
package com.rsinc.webretail.b2c.estore.util;

import java.util.ArrayList;
import java.util.List;

import com.rsinc.webretail.b2c.estore.domain.User;
import com.rsinc.webretail.b2c.estore.entity.UserBean;

/**
 * @author Roshan Titus
 *
 */
public class EntityConversionUtils {

	/**
	 * 
	 */
	private EntityConversionUtils() {
		// TODO initialize object
	}
	
	public static User convertUserBean2User(UserBean userBean)
	{
		User user = null;
		if(null != userBean)
		{
			user = new User();
			user.setUserId(userBean.getUserId());
			if(null != userBean.getParty())
			{
				user.setFirstName(userBean.getParty().getFirstName());
				user.setMiddleName(userBean.getParty().getMiddleName());
				user.setLastName(userBean.getParty().getLastName());
				user.setGender(userBean.getParty().getGender());
				user.setEmail(userBean.getParty().getEmail());
				user.setDateOfBirth(userBean.getParty().getDateOfBirth());
				user.setBusinessPhoneNumber(userBean.getParty().getBusinessPhoneNumber());
				user.setHomePhoneNumber(userBean.getParty().getHomePhoneNumber());
				user.setCellPhoneNumber(userBean.getParty().getCellPhoneNumber());
				
			}
		}
		return user;
	}
	
	public static List<User> convertUserBean2User(List<UserBean> userBeanList)
	{
		List<User> userList = null;
		if(null != userBeanList)
		{
			userList = new ArrayList<User>();
			for(UserBean userBean : userBeanList)
			{
				userList.add(convertUserBean2User(userBean));
			}
		}		
		return userList;
	}

}
