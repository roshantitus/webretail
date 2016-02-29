/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.web.controller.BaseController;

/**
 * @author Roshan Titus
 *
 */
@Controller
public class ManageOrdersController extends BaseController {

	@Inject
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageOrdersController.class);
	
    @RequestMapping(value="/admin/orderList.html", method=RequestMethod.GET)
    public String viewOrderHistory(Locale locale) {
        return "orderList";
    }
    
    @RequestMapping(value = "/admin/order/list/all", method = RequestMethod.GET)
    public @ResponseBody List<Order> viewAllOrders() throws ApplicationException, SystemException {
        return eStoreAdminService.getAllOrders();
    }
    
    @RequestMapping(value = "/admin/order/list/pending", method = RequestMethod.GET)
    public @ResponseBody List<Order> viewPendingOrders() throws ApplicationException, SystemException {
        return eStoreAdminService.getAllPendingOrders();
    }
    
    @RequestMapping(value = "/admin/order/add", method = RequestMethod.POST)
    public @ResponseBody Long addOrder(Order order) throws ApplicationException, SystemException {
        return eStoreAdminService.addOrder(order);
    }	
    
    @RequestMapping(value = "/admin/order/view", method = RequestMethod.GET)
    public @ResponseBody Order viewOrder(String productId) throws ApplicationException, SystemException {
        return eStoreAdminService.getOrder(Long.valueOf(productId));
    }    
    
    @RequestMapping(value = "/admin/order/edit", method = RequestMethod.POST)
    public @ResponseBody Boolean editOrder(Order order) throws ApplicationException, SystemException {
        return eStoreAdminService.updateOrder(order);
    }       
    
    @RequestMapping(value = "/admin/order/delete", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteOrder(String productId) throws ApplicationException, SystemException {
        return eStoreAdminService.deleteOrder(Long.valueOf(productId));
    }	
}
