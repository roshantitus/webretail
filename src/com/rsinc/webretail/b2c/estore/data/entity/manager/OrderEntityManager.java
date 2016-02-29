/**
 * 
 */
package com.rsinc.webretail.b2c.estore.data.entity.manager;

import java.util.List;

import com.rsinc.webretail.b2c.estore.data.entity.OrderBean;
import com.rsinc.webretail.b2c.estore.data.entity.enums.OrderStatus;

/**
 * @author Roshan Titus
 *
 */
public interface OrderEntityManager extends BaseEntityManager<OrderBean>{


	/**
	 * @param orderStatusList
	 * @return
	 */
	List<OrderBean> findOrdersByStatus(List<OrderStatus> orderStatusList);

}
