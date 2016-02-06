/**
 * 
 */
package com.rsinc.webretail.b2c.estore.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author Roshan Titus 
 *
 */
@Repository
public interface UserDao<UserBean> extends BaseDao<UserBean> {

	List<UserBean> fetchAllUsers();
}
