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

import com.rsinc.webretail.b2c.estore.business.model.Product;
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
public class ManageProductsController extends BaseController {

	@Inject
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageProductsController.class);
	
	
    @RequestMapping(value="/admin/productList.html", method=RequestMethod.GET)
    public String viewAllProducts(Locale locale) {
        return "productList";
    }
	
	//REST APIS	
//    @RequestMapping(value = "/admin/product/list/all", method = RequestMethod.GET)
//    public @ResponseBody List<Product> viewAllProducts() throws ApplicationException, SystemException {
//        return eStoreAdminService.getAllProducts();
//    }
//    
//    @RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
//    public @ResponseBody Long addProduct(Product product) throws ApplicationException, SystemException {
//        return eStoreAdminService.addProduct(product);
//    }	
//    
//    @RequestMapping(value = "/admin/product/view", method = RequestMethod.GET)
//    public @ResponseBody Product viewProduct(String productId) throws ApplicationException, SystemException {
//        return eStoreAdminService.getProduct(Long.valueOf(productId));
//    }    
//    
//    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
//    public @ResponseBody Boolean editProduct(Product product) throws ApplicationException, SystemException {
//        return eStoreAdminService.updateProduct(product);
//    }       
//    
//    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.GET)
//    public @ResponseBody Boolean deleteProduct(String productId) throws ApplicationException, SystemException {
//        return eStoreAdminService.deleteProduct(Long.valueOf(productId));
//    }	
}
