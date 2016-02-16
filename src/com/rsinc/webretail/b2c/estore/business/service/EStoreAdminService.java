/**
 * 
 */
package com.rsinc.webretail.b2c.estore.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rsinc.webretail.b2c.estore.business.model.User;

/**
 * @author Roshan Titus
 *
 */
@Service
public interface EStoreAdminService extends EStoreService{

	List<User> getAllUsers();
	
	//ProductBean addProduct(ProductBean product);
	//CategoryBean addCategory(CategoryBean category);
	
	//void deleteProduct(ProductBean product);
	//void deleteCategory(CategoryBean category);
	//void deleteUser(UserBean user);
	
	//void updateProduct(ProductBean product);
	//void updateCategory(CategoryBean category);
	
}
