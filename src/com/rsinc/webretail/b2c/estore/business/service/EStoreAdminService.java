/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rsinc.webretail.b2c.estore.business.model.Category;
import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.model.Product;
import com.rsinc.webretail.b2c.estore.business.model.User;
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
	List<User> getAllUsers() throws ApplicationException, SystemException;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<User> getAllUsers(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param valueOf
	 * @return
	 */
	User getUser(Long userId) throws ApplicationException, SystemException;

	/**
	 * @param user
	 * @return
	 */
	Boolean updateUser(User user) throws ApplicationException, SystemException;

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
	List<Category> getAllCategories() throws ApplicationException, SystemException;
	
	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Category> getAllCategories(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param category
	 * @return
	 */
	Long addCategory(Category category) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	Category getCategory(Long categoryId) throws ApplicationException, SystemException;

	/**
	 * @param category
	 * @return
	 */
	Boolean updateCategory(Category category) throws ApplicationException, SystemException;

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
	List<Product> getAllProducts() throws ApplicationException, SystemException;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Product> getAllProducts(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;
	
	/**
	 * @param product
	 * @return
	 */
	Long addProduct(Product product) throws ApplicationException, SystemException;

	/**
	 * @param valueOf
	 * @return
	 */
	Product getProduct(Long productId) throws ApplicationException, SystemException;

	/**
	 * @param product
	 * @return
	 */
	Boolean updateProduct(Product product) throws ApplicationException, SystemException;

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
	List<Order> getAllOrders() throws ApplicationException, SystemException ;

	/**
	 * 
	 * @param resultLoadCriteria
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Order> getAllOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException ;
	
	/**
	 * @param order
	 * @return
	 */
	Long addOrder(Order order) throws ApplicationException,
	SystemException ;

	/**
	 * @param valueOf
	 * @return
	 */
	Order getOrder(Long valueOf) throws ApplicationException,
	SystemException ;

	/**
	 * @param order
	 * @return
	 */
	Boolean updateOrder(Order order) throws ApplicationException,
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
	List<Order> getAllPendingOrders() throws ApplicationException,
	SystemException ;

	/**
	 * Returns orders with status PROCESSING
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Order> getAllInProgressOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status SHIPPED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Order> getAllShippedOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status DELIVERED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Order> getAllDeliveredOrders() throws ApplicationException,
	SystemException ;
	
	/**
	 * Returns orders with status RETURNED
	 * @return
	 * @throws ApplicationException
	 * @throws SystemException
	 */
	List<Order> getAllReturnedOrders() throws ApplicationException,
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
	List<Order> getAllPendingOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;

	/**
	 * @param resultLoadCriteria
	 * @return
	 * @throws SystemException 
	 * @throws ApplicationException 
	 */
	List<Order> getAllShippedOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;

	/**
	 * @param resultLoadCriteria
	 * @return
	 * @throws SystemException 
	 * @throws ApplicationException 
	 */
	List<Order> getAllReturnedOrders(ResultLoadCriteria resultLoadCriteria) throws ApplicationException, SystemException;	
}
