/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager;

import java.util.List;

import com.rsinc.webretail.b2c.estore.data.entity.CategoryBean;
import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;

/**
 * @author Roshan Titus
 *
 */
public interface OrderEntityManager extends BaseEntityManager<OrderBean>{

	/**
	 * @return
	 */
	List<OrderBean> getPendingOrders();

}
