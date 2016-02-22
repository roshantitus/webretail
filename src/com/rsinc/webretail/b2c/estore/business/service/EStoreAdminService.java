/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;

/**
 * @author Roshan Titus
 *
 */
@Service
public interface EStoreAdminService extends EStoreService{

	List<User> getAllUsers() throws ApplicationException, SystemException;
	
	//ProductBean addProduct(ProductBean product) throws ApplicationException, SystemException;
	//CategoryBean addCategory(CategoryBean category) throws ApplicationException, SystemException;
	
	//void deleteProduct(ProductBean product) throws ApplicationException, SystemException;
	//void deleteCategory(CategoryBean category) throws ApplicationException, SystemException;
	//void deleteUser(UserBean user) throws ApplicationException, SystemException;
	
	//void updateProduct(ProductBean product) throws ApplicationException, SystemException;
	//void updateCategory(CategoryBean category) throws ApplicationException, SystemException;
	
}
