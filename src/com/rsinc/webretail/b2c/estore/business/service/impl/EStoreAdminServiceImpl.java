/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rsinc.webretail.b2c.estore.business.domain.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.UserBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.enums.OrderStatus;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
import com.rsinc.webretail.b2c.estore.common.util.BeanUtils;

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
	public List<UserBean> getAllUsers(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return getUserEntityManager().findAll(resultLoadCriteria);
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllUsers()
	 */
	@Override
	public List<UserBean> getAllUsers() throws ApplicationException, SystemException{

		return getUserEntityManager().findAll();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getUser(java.lang.Long)
	 */
	@Override
	public UserBean getUser(Long userId) throws ApplicationException,
			SystemException {
		
		return getUserEntityManager().loadById(userId);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateUser(com.rsinc.webretail.b2c.estore.business.model.UserBean)
	 */
	@Override
	public Boolean updateUser(UserBean user) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			UserBean userBeanFromDB = getUserEntityManager().loadById(user.getUserId());
			BeanUtils.copyProperties(user, userBeanFromDB);
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
	public List<CategoryBean> getAllCategories(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		return getCategoryEntityManager().findAll(resultLoadCriteria);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreService#getAllCategories()
	 */
	@Override
	public List<CategoryBean> getAllCategories()  throws ApplicationException, SystemException{
		return getCategoryEntityManager().findAll();
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addCategory(com.rsinc.webretail.b2c.estore.business.model.CategoryBean)
	 */
	@Override
	public Long addCategory(CategoryBean categoryBean) throws ApplicationException,
			SystemException {
		
		try {
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
	public CategoryBean getCategory(Long categoryId) throws ApplicationException,
			SystemException {
		
		return getCategoryEntityManager().loadById(categoryId);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateCategory(com.rsinc.webretail.b2c.estore.business.model.CategoryBean)
	 */
	@Override
	public Boolean updateCategory(CategoryBean category)
			throws ApplicationException, SystemException {
		
		Boolean success = null;
		try {
			CategoryBean categoryBeanFromDB = getCategoryEntityManager().loadById(category.getCategoryId());
			BeanUtils.copyProperties(category, categoryBeanFromDB);
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
	public List<ProductBean> getAllProducts(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return getProductEntityManager().findAll(resultLoadCriteria);
	}	

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllProducts()
	 */
	@Override
	public List<ProductBean> getAllProducts() throws ApplicationException,
			SystemException {
		return getProductEntityManager().findAll();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addProduct(com.rsinc.webretail.b2c.estore.business.model.ProductBean)
	 */
	@Override
	public Long addProduct(ProductBean productBean) throws ApplicationException,
			SystemException {
		try {
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
	public ProductBean getProduct(Long productId) throws ApplicationException,
			SystemException {
		return getProductEntityManager().loadById(productId);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateProduct(com.rsinc.webretail.b2c.estore.business.model.ProductBean)
	 */
	@Override
	public Boolean updateProduct(ProductBean product) throws ApplicationException,
			SystemException {
		Boolean success = null;
		try {
			ProductBean productBeanFromDB = getProductEntityManager().loadById(product.getProductId());
			BeanUtils.copyProperties(product, productBeanFromDB);
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
	public List<OrderBean> getAllOrders(ResultLoadCriteria resultLoadCriteria)
			throws ApplicationException, SystemException {
		
		return getOrderEntityManager().findAll(resultLoadCriteria);
	}

	
	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllOrders()
	 */
	@Override
	public List<OrderBean> getAllOrders()  throws ApplicationException,
	SystemException {
		return getOrderEntityManager().findAll();
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#addOrder(com.rsinc.webretail.b2c.estore.business.model.OrderBean)
	 */
	@Override
	public Long addOrder(OrderBean orderBean)  throws ApplicationException, SystemException {
		try {
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
	public OrderBean getOrder(Long orderId)  throws ApplicationException,
	SystemException {
		return getOrderEntityManager().loadById(orderId);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#updateOrder(com.rsinc.webretail.b2c.estore.business.model.OrderBean)
	 */
	@Override
	public Boolean updateOrder(OrderBean order)  throws ApplicationException,
	SystemException {
		Boolean success = null;
		try {
			OrderBean orderBeanFromDB = getOrderEntityManager().loadById(order.getOrderId());
			BeanUtils.copyProperties(order, orderBeanFromDB);
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
	public List<OrderBean> getAllPendingOrders()  throws ApplicationException,
	SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.NEW);
		orderStatusList.add(OrderStatus.PAYMENT_RECIEVED);
		return getOrderEntityManager().findOrdersByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllPendingOrders(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<OrderBean> getAllPendingOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException,
	SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.NEW);
		orderStatusList.add(OrderStatus.PAYMENT_RECIEVED);
		return getOrderEntityManager().findOrdersByStatus(resultLoadCriteria, orderStatusList);
	}

	
	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllInProgressOrders()
	 */
	@Override
	public List<OrderBean> getAllInProgressOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.PROCESSING);
		return getOrderEntityManager().findOrdersByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllShippedOrders()
	 */
	@Override
	public List<OrderBean> getAllShippedOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.SHIPPED);
		return getOrderEntityManager().findOrdersByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllDeliveredOrders()
	 */
	@Override
	public List<OrderBean> getAllDeliveredOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.DELIVERED);
		return getOrderEntityManager().findOrdersByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllReturnedOrders()
	 */
	@Override
	public List<OrderBean> getAllReturnedOrders() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.RETURNED);
		return getOrderEntityManager().findOrdersByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllShippedOrders(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<OrderBean> getAllShippedOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException,
	SystemException {
		
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.SHIPPED);
		return getOrderEntityManager().findOrdersByStatus(resultLoadCriteria, orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getAllReturnedOrders(com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria)
	 */
	@Override
	public List<OrderBean> getAllReturnedOrders(
			ResultLoadCriteria resultLoadCriteria) throws ApplicationException,
			SystemException {
		
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.RETURNED);
		return getOrderEntityManager().findOrdersByStatus(resultLoadCriteria, orderStatusList);
	}
	
	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getReturnedOrderCount()
	 */
	@Override
	public Long getReturnedOrderCount() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.RETURNED);
		return getOrderEntityManager().findOrderCountByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getShippedOrderCount()
	 */
	@Override
	public Long getShippedOrderCount() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.SHIPPED);
		return getOrderEntityManager().findOrderCountByStatus(orderStatusList);
	}

	/* (non-Javadoc)
	 * @see com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService#getPendingOrderCount()
	 */
	@Override
	public Long getPendingOrderCount() throws ApplicationException,
			SystemException {
		List<OrderStatus> orderStatusList = new ArrayList<OrderStatus>();
		orderStatusList.add(OrderStatus.NEW);
		orderStatusList.add(OrderStatus.PAYMENT_RECIEVED);
		return getOrderEntityManager().findOrderCountByStatus(orderStatusList);
	}

}
