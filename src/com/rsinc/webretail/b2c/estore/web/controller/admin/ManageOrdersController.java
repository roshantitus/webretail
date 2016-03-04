/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsinc.webretail.b2c.estore.business.model.Order;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.common.paging.ResultLoadCriteria;
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
	
	//
    @RequestMapping(value="/admin/orderList.html", method=RequestMethod.GET)
    public String viewOrderHistory(Locale locale) {
        return "orderList";
    }
    
    @RequestMapping(value = "/admin/order/list/all/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllOrders(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
        return eStoreAdminService.getAllOrders(getResultLoadCriteria(pageSize, page));
    }

	/**
	 * @param pageSize
	 * @param page
	 * @return
	 */
	private ResultLoadCriteria getResultLoadCriteria(String pageSize,
			String page) {
		ResultLoadCriteria resultLoadCriteria = new ResultLoadCriteria();
    	Integer first = (Integer.valueOf(page) - 1) * Integer.valueOf(pageSize);
    	resultLoadCriteria.setFirst(first);
    	resultLoadCriteria.setPageSize(Integer.valueOf(pageSize));
		return resultLoadCriteria;
	}
     
    @RequestMapping(value = "/admin/order/count/all/", method = RequestMethod.GET)    
    public @ResponseBody Long getTotalOrderCount() throws ApplicationException, SystemException {
        return eStoreAdminService.getTotalOrderCount();    
    }
    
    @RequestMapping(value="/admin/viewOrder.html", method=RequestMethod.GET)
    public String viewOrder() {
        return "viewOrder";
    } 
    
    //
    @RequestMapping(value="/admin/pendingOrderList.html", method=RequestMethod.GET)
    public String viewPendingOrders(Locale locale) {
        return "pendingOrderList";
    }    
    
    @RequestMapping(value = "/admin/order/list/pending/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllPendingOrders(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
        return eStoreAdminService.getAllPendingOrders(getResultLoadCriteria(pageSize, page));
    }
    
    @RequestMapping(value = "/admin/order/count/pending/", method = RequestMethod.GET)    
    public @ResponseBody Long getPendingOrderCount(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
        return eStoreAdminService.getPendingOrderCount();    
    }  
    
    //
    @RequestMapping(value="/admin/shippedOrderList.html", method=RequestMethod.GET)
    public String viewShippedOrders(Locale locale) {
        return "shippedOrderList";
    }         
    
    @RequestMapping(value = "/admin/order/list/shipped/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllShippedOrders(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
        return eStoreAdminService.getAllShippedOrders(getResultLoadCriteria(pageSize, page));
    }
    
    @RequestMapping(value = "/admin/order/count/shipped/", method = RequestMethod.GET)    
    public @ResponseBody Long getShippedOrderCount() throws ApplicationException, SystemException {
        return eStoreAdminService.getShippedOrderCount();    
    }      
    
    //
    @RequestMapping(value="/admin/returnedOrderList.html", method=RequestMethod.GET)
    public String viewReturnedOrders(Locale locale) {
        return "returnedOrderList";
    }     
     
    @RequestMapping(value = "/admin/order/list/returned/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<Order> getAllReturnedOrders(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
        return eStoreAdminService.getAllReturnedOrders(getResultLoadCriteria(pageSize, page));
    }    

    @RequestMapping(value = "/admin/order/count/returned/", method = RequestMethod.GET)    
    public @ResponseBody Long getReturnedOrderCount() throws ApplicationException, SystemException {
        return eStoreAdminService.getReturnedOrderCount();    
    }      
    
    
    @RequestMapping(value = "/admin/order/view", method = RequestMethod.GET)
    public @ResponseBody Order viewOrder(String productId) throws ApplicationException, SystemException {
        return eStoreAdminService.getOrder(Long.valueOf(productId));
    }    
     
    @RequestMapping(value = "/admin/order/add", method = RequestMethod.POST)
    public @ResponseBody Long addOrder(Order order) throws ApplicationException, SystemException {
        return eStoreAdminService.addOrder(order);
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
