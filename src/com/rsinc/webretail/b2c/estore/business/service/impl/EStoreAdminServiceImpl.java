/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.model.Product;
import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
import com.rsinc.webretail.b2c.estore.common.util.BeanUtils;
import com.rsinc.webretail.b2c.estore.common.util.EntityConversionUtils;
import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.data.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;
import com.rsinc.webretail.b2c.estore.data.entity.enums.OrderStatus;

/**
 * @author Roshan Titus
 *
 */
@Service
@Transactional
public class EStoreAdminServiceImpl extends BaseEStoreServiceImpl implements EStoreAdminService {


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalUserCount()
	 */
	@Override
	public Long getTotalUserCount() throws ApplicationException,
			SystemException {
		return getUserEntityManager().getTotalRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalUserCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalUserCount(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {

		return getUserEntityManager().getTotalRecordCount(resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllUsers(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<User> getAllUsers(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return EntityConversionUtils.convertUserBean2User(getUserEntityManager().findAll(resultLoadCriteria));
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllUsers()
	 */
	@Override
	public List<User> getAllUsers() throws ApplicationException, SystemException{

		return EntityConversionUtils.convertUserBean2User(getUserEntityManager().findAll());
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getUser(java.lang.Long)
	 */
	@Override
	public User getUser(Long userId) throws ApplicationException,
			SystemException {
		
		return EntityConversionUtils.convertUserBean2User(getUserEntityManager().loadById(userId));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateUser(com.rsinc.webretail.b2c.estore.business.model.User)
	 */
	@Override
	public Boolean updateUser(User user) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			UserBean userBean = EntityConversionUtils.convertUser2UserBean(user);
			UserBean userBeanFromDB = getUserEntityManager().loadById(user.getUserId());
			BeanUtils.copyProperties(userBean, userBeanFromDB);
			getUserEntityManager().update(userBeanFromDB);
			success = true;
		} catch (BeansException e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#deleteUser(java.lang.Long)
	 */
	@Override
	public Boolean deleteUser(Long userId) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			getUserEntityManager().deleteById(userId);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#enableUser(java.lang.Long)
	 */
	@Override
	public Boolean enableUser(Long userId) throws ApplicationException,
			SystemException {
		// TODO implement method functionality
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#disableUser(java.lang.Long)
	 */
	@Override
	public Boolean disableUser(Long valueOf) {
		// TODO implement method functionality
		return null;
	}
	


	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalCategoryCount()
	 */
	@Override
	public Long getTotalCategoryCount() throws ApplicationException,
			SystemException {
		return getCategoryEntityManager().getTotalRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalCategoryCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalCategoryCount(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return getCategoryEntityManager().getTotalRecordCount(resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllCategories(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<Category> getAllCategories(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		return EntityConversionUtils.convertCategoryBean2Category(getCategoryEntityManager().findAll(resultLoadCriteria));
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreService#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories()  throws ApplicationException, SystemException{
		return EntityConversionUtils.convertCategoryBean2Category(getCategoryEntityManager().findAll());
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addCategory(com.rsinc.webretail.b2c.estore.business.model.Category)
	 */
	@Override
	public Long addCategory(Category category) throws ApplicationException,
			SystemException {
		
		try {
			CategoryBean categoryBean = EntityConversionUtils.convertCategory2CategoryBean(category);
			getCategoryEntityManager().create(categoryBean);
			return categoryBean.getCategoryId();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getCategory(java.lang.Long)
	 */
	@Override
	public Category getCategory(Long categoryId) throws ApplicationException,
			SystemException {
		
		return EntityConversionUtils.convertCategoryBean2Category(getCategoryEntityManager().loadById(categoryId));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateCategory(com.rsinc.webretail.b2c.estore.business.model.Category)
	 */
	@Override
	public Boolean updateCategory(Category category)
			throws ApplicationException, SystemException {
		
		Boolean success = null;
		try {
			CategoryBean categoryBean = EntityConversionUtils.convertCategory2CategoryBean(category);
			CategoryBean categoryBeanFromDB = getCategoryEntityManager().loadById(category.getCategoryId());
			BeanUtils.copyProperties(categoryBean, categoryBeanFromDB);
			getCategoryEntityManager().update(categoryBeanFromDB);
			success = true;
		} catch (BeansException e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#deleteCategory(java.lang.Long)
	 */
	@Override
	public Boolean deleteCategory(Long categoryId) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			getCategoryEntityManager().deleteById(categoryId);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}
	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalProductCount()
	 */
	@Override
	public Long getTotalProductCount() throws ApplicationException,
			SystemException {
		return getProductEntityManager().getTotalRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalProductCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalProductCount(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		return getProductEntityManager().getTotalRecordCount(resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllProducts(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<Product> getAllProducts(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return EntityConversionUtils.convertProductBean2Product(getProductEntityManager().findAll(resultLoadCriteria));
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() throws ApplicationException,
			SystemException {
		return EntityConversionUtils.convertProductBean2Product(getProductEntityManager().findAll());
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addProduct(com.rsinc.webretail.b2c.estore.business.model.Product)
	 */
	@Override
	public Long addProduct(Product product) throws ApplicationException,
			SystemException {
		try {
			ProductBean productBean = EntityConversionUtils.convertProduct2ProductBean(product);
			getProductEntityManager().create(productBean);
			return productBean.getProductId();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getProduct(java.lang.Long)
	 */
	@Override
	public Product getProduct(Long productId) throws ApplicationException,
			SystemException {
		return EntityConversionUtils.convertProductBean2Product(getProductEntityManager().loadById(productId));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateProduct(com.rsinc.webretail.b2c.estore.business.model.Product)
	 */
	@Override
	public Boolean updateProduct(Product product) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			ProductBean productBean = EntityConversionUtils.convertProduct2ProductBean(product);
			ProductBean productBeanFromDB = getProductEntityManager().loadById(product.getProductId());
			BeanUtils.copyProperties(productBean, productBeanFromDB);
			getProductEntityManager().update(productBeanFromDB);
			success = true;
		} catch (BeansException e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#deleteProduct(java.lang.Long)
	 */
	@Override
	public Boolean deleteProduct(Long productId) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			getProductEntityManager().deleteById(productId);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalOrderCount()
	 */
	@Override
	public Long getTotalOrderCount() throws ApplicationException,
			SystemException {
		return getOrderEntityManager().getTotalRecordCount();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getTotalOrderCount(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public Long getTotalOrderCount(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		return getOrderEntityManager().getTotalRecordCount(resultLoadCriteria);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllOrders(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<Order> getAllOrders(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findAll(resultLoadCriteria));
	}

	
	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllOrders()
	 */
	@Override
	public List<Order> getAllOrders()  throws ApplicationException,
	SystemException {
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findAll());
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addOrder(com.rsinc.webretail.b2c.estore.business.model.Order)
	 */
	@Override
	public Long addOrder(Order order)  throws ApplicationException, SystemException {
		try {
			OrderBean orderBean = EntityConversionUtils.convertOrder2OrderBean(order);
			getOrderEntityManager().create(orderBean);
			return orderBean.getOrderId();
			
		} catch (Exception e) {

		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getOrder(java.lang.Long)
	 */
	@Override
	public Order getOrder(Long orderId)  throws ApplicationException,
	SystemException {
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().loadById(orderId));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateOrder(com.rsinc.webretail.b2c.estore.business.model.Order)
	 */
	@Override
	public Boolean updateOrder(Order order)  throws ApplicationException,
	SystemException {
		Boolean success = null;
		try {
			OrderBean orderBean = EntityConversionUtils.convertOrder2OrderBean(order);
			OrderBean orderBeanFromDB = getOrderEntityManager().loadById(order.getOrderId());
			BeanUtils.copyProperties(orderBean, orderBeanFromDB);
			getOrderEntityManager().update(orderBeanFromDB);
			success = true;
		} catch (BeansException e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#deleteOrder(java.lang.Long)
	 */
	@Override
	public Boolean deleteOrder(Long orderId)  throws ApplicationException,
	SystemException {
		Boolean success = null;
		try {
			getOrderEntityManager().deleteById(orderId);
			success = true;
		} catch (Exception e) {
			success = false;
		}
		return success;
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getPendingOrders()
	 */
	@Override
	public List<Order> getAllPendingOrders()  throws ApplicationException,
	SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.NEW);
		orderStatusList.add(OrderStatus.PAYMENT_RECIEVED);
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findOrdersByStatus(orderStatusList));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllInProgressOrders()
	 */
	@Override
	public List<Order> getAllInProgressOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.PROCESSING);
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findOrdersByStatus(orderStatusList));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllShippedOrders()
	 */
	@Override
	public List<Order> getAllShippedOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.SHIPPED);
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findOrdersByStatus(orderStatusList));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllDeliveredOrders()
	 */
	@Override
	public List<Order> getAllDeliveredOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.DELIVERED);
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findOrdersByStatus(orderStatusList));
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllReturnedOrders()
	 */
	@Override
	public List<Order> getAllReturnedOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.RETURNED);
		return EntityConversionUtils.convertOrderBean2Order(getOrderEntityManager().findOrdersByStatus(orderStatusList));
	}



}
