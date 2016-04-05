/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rsinc.webretail.b2c.estore.business.domain.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.ProductBean;
import com.rsinc.webretail.b2c.estore.business.domain.entity.UserBean;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;

/**
 * @author Roshan Titus
 *
 */
@Service
public interface EStoreAdminService extends EStoreService{

	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalUserCount() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalUserCount(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<UserBean> getAllUsers() throws ApplicationException, SystemException;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<UserBean> getAllUsers(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param valueOf
	 * @return
	 */
	UserBean getUser(Long userId) throws ApplicationException, SystemException;

	/**
	 * @param user
	 * @return
	 */
	Boolean updateUser(UserBean user) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	Boolean deleteUser(Long userId) throws ApplicationException, SystemException;
	
	/**
	 * @param valueOf
	 * @return
	 */
	Boolean enableUser(Long userId) throws ApplicationException, SystemException;


	/**
	 * @param valueOf
	 * @return
	 */
	Boolean disableUser(Long valueOf);
	
	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalCategoryCount() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalCategoryCount(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;	
	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<CategoryBean> getAllCategories() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<CategoryBean> getAllCategories(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param category
	 * @return
	 */
	Long addCategory(CategoryBean category) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	CategoryBean getCategory(Long categoryId) throws ApplicationException, SystemException;

	/**
	 * @param category
	 * @return
	 */
	Boolean updateCategory(CategoryBean category) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	Boolean deleteCategory(Long categoryId) throws ApplicationException, SystemException;

	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalProductCount() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalProductCount(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;	
	
	/**
	 * @return
	 */
	List<ProductBean> getAllProducts() throws ApplicationException, SystemException;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<ProductBean> getAllProducts(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param product
	 * @return
	 */
	Long addProduct(ProductBean product) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	ProductBean getProduct(Long productId) throws ApplicationException, SystemException;

	/**
	 * @param product
	 * @return
	 */
	Boolean updateProduct(ProductBean product) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	Boolean deleteProduct(Long productId) throws ApplicationException, SystemException;

	/**
	 * 
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalOrderCount() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	Long getTotalOrderCount(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;	
	
	/**
	 * @return
	 */
	List<OrderBean> getAllOrders() throws ApplicationException, SystemException ;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException ;
	
	/**
	 * @param order
	 * @return
	 */
	Long addOrder(OrderBean order) throws ApplicationException,
	SystemException ;

	/**
	 * @param valueOf
	 * @return
	 */
	OrderBean getOrder(Long valueOf) throws ApplicationException,
	SystemException ;

	/**
	 * @param order
	 * @return
	 */
	Boolean updateOrder(OrderBean order) throws ApplicationException,
	SystemException ;

	/**
	 * @param valueOf
	 * @return
	 */
	Boolean deleteOrder(Long valueOf) throws ApplicationException,
	SystemException ;

	/**
	 * Returns orders with status NEW and PAYMENT_RECIEVED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllPendingOrders() throws ApplicationException,
	SystemException ;

	/**
	 * Returns orders with status PROCESSING
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllInProgressOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status SHIPPED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllShippedOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status DELIVERED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllDeliveredOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status RETURNED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<OrderBean> getAllReturnedOrders() throws ApplicationException,
	SystemException ;

	/**
	 * @return
	 */
	Long getReturnedOrderCount() throws ApplicationException,
	SystemException ;

	/**
	 * @return
	 */
	Long getShippedOrderCount() throws ApplicationException,
	SystemException ;

	/**
	 * @return
	 */
	Long getPendingOrderCount() throws ApplicationException,
	SystemException ;

	/**
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException 
	 * @throws SystemException 
	 */
	List<OrderBean> getAllPendingOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;

	/**
	 * @param resultLoadCriteria
	 * @return
	 * @throws SystemException 
	 * @throws ApplicationException 
	 */
	List<OrderBean> getAllShippedOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;

	/**
	 * @param resultLoadCriteria
	 * @return
	 * @throws SystemException 
	 * @throws ApplicationException 
	 */
	List<OrderBean> getAllReturnedOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;	
}
