/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.util;

import java.util.ArrayList;
import java.util.List;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.model.Product;
import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.data.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;

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
	
	//**********************************************
	//Converting from entity beans to domain object.	
	//**********************************************
	
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

	/**
	 * @param findAll
	 * @return
	 */
	public static List<Category> convertCategoryBean2Category(List<CategoryBean> categoryBeanList) {
		
		List<Category> categoryList = null;
		if(null != categoryBeanList)
		{
			categoryList = new ArrayList<Category>();
			for(CategoryBean categoryBean : categoryBeanList)
			{
				categoryList.add(convertCategoryBean2Category(categoryBean));
			}			
		}
		return categoryList;
	}

	/**
	 * @param categoryBean
	 * @return
	 */
	public static Category convertCategoryBean2Category(
			CategoryBean categoryBean) {
		
		Category category = null;
		if(null != categoryBean)
		{
			category = new Category();
			category.setCategoryId(categoryBean.getCategoryId());
			category.setCategoryName(categoryBean.getCategoryName());
			category.setCategoryDescription(categoryBean.getCategoryDescription());
		}
		return category;
	}

	/**
	 * @param findAll
	 * @return
	 */
	public static List<Product> convertProductBean2Product(List<ProductBean> productBeanList) {
		List<Product> productList = null;
		if(null != productBeanList)
		{
			productList = new ArrayList<Product>();
			for(ProductBean productBean : productBeanList)
			{
				productList.add(convertProductBean2Product(productBean));
			}
		}		
		return productList;
	}

	/**
	 * @param findAll
	 * @return
	 */
	public static List<Order> convertOrderBean2Order(List<OrderBean> orderBeanList) {
		List<Order> orderList = null;
		if(null != orderBeanList)
		{
			orderList = new ArrayList<Order>();
			for(OrderBean orderBean : orderBeanList)
			{
				orderList.add(convertOrderBean2Order(orderBean));
			}
		}		
		return orderList;
	}

	/**
	 * @param loadById
	 * @return
	 */
	public static Order convertOrderBean2Order(OrderBean orderBean) {
		Order order = null;
		if(null != orderBean)
		{
			order = new Order();
			order.setOrderId(orderBean.getOrderId());
			order.setOrderDate(orderBean.getOrderDate());
			order.setOrderStatus(orderBean.getOrderStatus());
		}
		return order;
	}
	
	/**
	 * @param loadById
	 * @return
	 */
	public static Product convertProductBean2Product(ProductBean productBean) {
		Product product = null;
		if(null != productBean)
		{
			product = new Product();
			product.setProductId(productBean.getProductId());
			product.setProductName(productBean.getProductName());
			product.setProductDescription(productBean.getProductDescription());
			product.setQuantity(productBean.getQuantity());
			product.setUnitPrice(productBean.getUnitPrice());
		}
		return product;
	}	

	//**********************************************
	//Converting from domain object to entity beans.
	//**********************************************

	/**
	 * @param user
	 * @return
	 */
	public static UserBean convertUser2UserBean(User user) {
		UserBean userBean = null;
		if(null != user)
		{
			userBean = new UserBean();
			userBean.setUserId(user.getUserId());
			if(null == userBean.getParty())
			{
				userBean.setParty(new PartyBean());
				userBean.getParty().setFirstName(user.getFirstName());
				userBean.getParty().setMiddleName(user.getMiddleName());
				userBean.getParty().setLastName(user.getLastName());
				userBean.getParty().setGender(user.getGender());
				userBean.getParty().setEmail(user.getEmail());
				userBean.getParty().setDateOfBirth(user.getDateOfBirth());
				userBean.getParty().setBusinessPhoneNumber(user.getBusinessPhoneNumber());
				userBean.getParty().setHomePhoneNumber(user.getHomePhoneNumber());
				userBean.getParty().setCellPhoneNumber(user.getCellPhoneNumber());
				
			}
		}
		return userBean;
	}

	/**
	 * @param category
	 * @return
	 */
	public static CategoryBean convertCategory2CategoryBean(Category category) {
		
		CategoryBean categoryBean = null;
		if(null != category)
		{
			categoryBean = new CategoryBean();
			categoryBean.setCategoryId(category.getCategoryId());
			categoryBean.setCategoryName(category.getCategoryName());
			categoryBean.setCategoryDescription(category.getCategoryDescription());
		}
		return categoryBean;
	}

	/**
	 * @param product
	 * @return
	 */
	public static ProductBean convertProduct2ProductBean(Product product) {
		ProductBean productBean = null;
		if(null != product)
		{
			productBean = new ProductBean();
			productBean.setProductId(product.getProductId());
			productBean.setProductName(product.getProductName());
			productBean.setProductDescription(product.getProductDescription());
			productBean.setQuantity(product.getQuantity());
			productBean.setUnitPrice(product.getUnitPrice());
		}
		return productBean;
	}

	/**
	 * @param order
	 * @return
	 */
	public static OrderBean convertOrder2OrderBean(Order order) {
		OrderBean orderBean = null;
		if(null != order)
		{
			orderBean = new OrderBean();
			orderBean.setOrderId(order.getOrderId());
			orderBean.setOrderDate(order.getOrderDate());
			orderBean.setOrderStatus(order.getOrderStatus());
		}
		return orderBean;
	}

}
