/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.model.Product;
import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.business.service.EStoreService;
import com.rsinc.webretail.b2c.estore.common.exception.application.RecordNotFoundException;
import com.rsinc.webretail.b2c.estore.common.exception.application.ValidationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.RetrievalFailureSystemException;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.data.entity.PartyBean;
import com.rsinc.webretail.b2c.estore.data.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;
import com.rsinc.webretail.b2c.estore.data.entity.manager.CategoryEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.OrderEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.ProductEntityManager;
import com.rsinc.webretail.b2c.estore.data.entity.manager.UserEntityManager;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public abstract class BaseEStoreServiceImpl implements EStoreService {

	@Inject
	private UserEntityManager userEntityManager;
	
	@Inject
	private CategoryEntityManager categoryEntityManager;
	
	@Inject
	private ProductEntityManager productEntityManager;
	
	@Inject
	private OrderEntityManager orderEntityManager;	

	
	protected UserEntityManager getUserEntityManager() {
		return userEntityManager;
	}	
	

	protected CategoryEntityManager getCategoryEntityManager() {
		return categoryEntityManager;
	}


	protected ProductEntityManager getProductEntityManager() {
		return productEntityManager;
	}


	protected OrderEntityManager getOrderEntityManager() {
		return orderEntityManager;
	}

	
	//**********************************************
	//Converting from entity beans to domain object.	
	//**********************************************
	
	public User convertToDTO(UserBean userBean)
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
	
	public List<User> convertToUserDTOList(List<UserBean> userBeanList)
	{
		List<User> userList = null;
		if(null != userBeanList)
		{
			userList = new ArrayList<User>();
			for(UserBean userBean : userBeanList)
			{
				userList.add(convertToDTO(userBean));
			}
		}		
		return userList;
	}

	/**
	 * @param findAll
	 * @return
	 */
	public List<Category> convertToCategoryDTOList(List<CategoryBean> categoryBeanList) {
		
		List<Category> categoryList = null;
		if(null != categoryBeanList)
		{
			categoryList = new ArrayList<Category>();
			for(CategoryBean categoryBean : categoryBeanList)
			{
				categoryList.add(convertToDTO(categoryBean));
			}			
		}
		return categoryList;
	}

	/**
	 * @param categoryBean
	 * @return
	 */
	public Category convertToDTO(
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
	public List<Product> convertToProductDTOList(List<ProductBean> productBeanList) {
		List<Product> productList = null;
		if(null != productBeanList)
		{
			productList = new ArrayList<Product>();
			for(ProductBean productBean : productBeanList)
			{
				productList.add(convertToDTO(productBean));
			}
		}		
		return productList;
	}

	/**
	 * @param findAll
	 * @return
	 */
	public List<Order> convertToOrderDTOList(List<OrderBean> orderBeanList) {
		List<Order> orderList = null;
		if(null != orderBeanList)
		{
			orderList = new ArrayList<Order>();
			for(OrderBean orderBean : orderBeanList)
			{
				orderList.add(convertToDTO(orderBean));
			}
		}		
		return orderList;
	}

	/**
	 * @param loadById
	 * @return
	 */
	public Order convertToDTO(OrderBean orderBean) {
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
	public Product convertToDTO(ProductBean productBean) {
		Product product = null;
		if(null != productBean)
		{
			product = new Product();
			product.setProductId(productBean.getProductId());
			product.setProductName(productBean.getProductName());
			product.setProductDescription(productBean.getProductDescription());
			product.setQuantity(productBean.getQuantity());
			product.setUnitPrice(productBean.getUnitPrice());
			if(null != productBean.getCategory())
			{
				Category category = new Category();
				category.setCategoryId(productBean.getCategory().getCategoryId());
				category.setCategoryName(productBean.getCategory().getCategoryName());
				category.setCategoryDescription(productBean.getCategory().getCategoryDescription());
				product.setCategory(category);
			}
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
	public UserBean convertToEntity(User user) throws RetrievalFailureSystemException,
	RecordNotFoundException, ValidationException{
		
		UserBean userBean = null;
		if(null != user)
		{
			if(null != user.getUserId())
			{
				userBean = userEntityManager.loadById(user.getUserId());
			}
			else
			{
				userBean = new UserBean();
				userBean.setUserId(user.getUserId());
			}	

			if(null == userBean.getParty())
			{
				userBean.setParty(new PartyBean());				
			}		
			if(user.getFirstName() != null)
				userBean.getParty().setFirstName(user.getFirstName());
			if(user.getMiddleName() != null)
				userBean.getParty().setMiddleName(user.getMiddleName());
			if(user.getLastName() != null)
				userBean.getParty().setLastName(user.getLastName());
			if(user.getGender() != null)
				userBean.getParty().setGender(user.getGender());
			if(user.getEmail() != null)
				userBean.getParty().setEmail(user.getEmail());
			if(user.getDateOfBirth() != null)
				userBean.getParty().setDateOfBirth(user.getDateOfBirth());
			if(user.getBusinessPhoneNumber() != null)
				userBean.getParty().setBusinessPhoneNumber(user.getBusinessPhoneNumber());
			if(user.getHomePhoneNumber() != null)
				userBean.getParty().setHomePhoneNumber(user.getHomePhoneNumber());
			if(user.getCellPhoneNumber() != null)
				userBean.getParty().setCellPhoneNumber(user.getCellPhoneNumber());
		}
		return userBean;
	}

	/**
	 * @param category
	 * @return
	 */
	public CategoryBean convertToEntity(Category category)  throws RetrievalFailureSystemException,
	RecordNotFoundException, ValidationException{
		
		CategoryBean categoryBean = null;
		if(null != category)
		{
			if(null != category.getCategoryId())
			{
				categoryBean = categoryEntityManager.loadById(category.getCategoryId());
			}
			else
			{
				categoryBean = new CategoryBean();
				categoryBean.setCategoryId(category.getCategoryId());				
			}
			if (category.getCategoryName() != null)
				categoryBean.setCategoryName(category.getCategoryName());
			if (category.getCategoryDescription() != null)
				categoryBean.setCategoryDescription(category.getCategoryDescription());
		}
		return categoryBean;
	}

	/**
	 * @param product
	 * @return
	 */
	public ProductBean convertToEntity(Product product) throws RetrievalFailureSystemException,
	RecordNotFoundException, ValidationException{
		
		ProductBean productBean = null;
		if(null != product)
		{
			if(null != product.getProductId())
			{
				productBean = productEntityManager.loadById(product.getProductId());
			}
			else
			{
				productBean = new ProductBean();
				productBean.setProductId(product.getProductId());			
			}			

			if(null != product.getProductName())
				productBean.setProductName(product.getProductName());
			if(null != product.getProductDescription())
				productBean.setProductDescription(product.getProductDescription());
			if(null != product.getQuantity())
				productBean.setQuantity(product.getQuantity());
			if(null != product.getUnitPrice())
				productBean.setUnitPrice(product.getUnitPrice());
			
			if(null != product.getCategory())
			{
				CategoryBean categoryBean = null;
				if(null != product.getCategory().getCategoryId())
				{
					categoryBean = categoryEntityManager.loadById(product.getCategory().getCategoryId());
				}
				else
				{
					categoryBean = new CategoryBean();
					categoryBean.setCategoryId(product.getCategory().getCategoryId());				
				}
				if (product.getCategory().getCategoryName() != null)
					categoryBean.setCategoryName(product.getCategory().getCategoryName());
				if (product.getCategory().getCategoryDescription() != null)
					categoryBean.setCategoryDescription(product.getCategory().getCategoryDescription());				

				productBean.setCategory(categoryBean);
			}			
		}
		return productBean;
	}

	/**
	 * @param order
	 * @return
	 */
	public OrderBean convertToEntity(Order order)   throws RetrievalFailureSystemException,
	RecordNotFoundException, ValidationException {
		
		OrderBean orderBean = null;
		if(null != order)
		{
			if(null != order.getOrderId())
			{
				orderBean = orderEntityManager.loadById(order.getOrderId());
			}
			else
			{
				orderBean = new OrderBean();
				orderBean.setOrderId(order.getOrderId());		
			}		
			if(order.getOrderDate() != null)
				orderBean.setOrderDate(order.getOrderDate());
			if(order.getOrderStatus() != null)
			orderBean.setOrderStatus(order.getOrderStatus());
		}
		return orderBean;
	}	
}
