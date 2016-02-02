/**
 * 
 */
package com.rs.webretail.b2c.estore.dao;

import java.util.List;

/**
 * @author Roshan Titus
 *
 */
public interface UserDao<UserBean> extends BaseDao<UserBean> {

	List<UserBean> fetchAllUsers();
}
