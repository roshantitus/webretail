/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rsinc.webretail.b2c.estore.business.model.Product;
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
    @RequestMapping(value = "/admin/product/list/all/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<Product> getAllProducts(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
    	ResultLoadCriteria resultLoadCriteria = new ResultLoadCriteria();
    	Integer first = (Integer.valueOf(page) - 1) * Integer.valueOf(pageSize);
    	resultLoadCriteria.setFirst(first);
    	resultLoadCriteria.setPageSize(Integer.valueOf(pageSize));    	
        return eStoreAdminService.getAllProducts(resultLoadCriteria);
    }
    
    @RequestMapping(value = "/admin/product/count/all/", method = RequestMethod.GET)    
    public @ResponseBody Long getTotalCategoryCount() throws ApplicationException, SystemException {
        return eStoreAdminService.getTotalCategoryCount();    
    }
    
    @RequestMapping(value="/admin/editProduct.html", method=RequestMethod.GET)
    public ModelAndView showEditProductForm(String productId) throws ApplicationException, SystemException {
    	
    	ModelAndView modelAndView = new ModelAndView("editProduct");
    	modelAndView.addObject("categoryList", eStoreAdminService.getAllCategories());
    	modelAndView.addObject("product", eStoreAdminService.getProduct(Long.valueOf(productId)));
        return modelAndView;
    }    
    
    @RequestMapping(value="/admin/editProduct.html", method=RequestMethod.POST)
    public String editProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult, Model model) throws ApplicationException, SystemException {
    	
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors found");
            return "editProduct";
        } 
        
    	try {
			eStoreAdminService.updateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:productList.html";
    }     
    
    @RequestMapping(value="/admin/addProduct.html", method=RequestMethod.GET)
    public ModelAndView showAddProductForm()  throws ApplicationException, SystemException {
    	
    	ModelAndView modelAndView = new ModelAndView("addProduct");
    	modelAndView.addObject("categoryList", eStoreAdminService.getAllCategories());
    	modelAndView.addObject("product", new Product());
        return modelAndView;    	
    }   
    
    @RequestMapping(value="/admin/addProduct.html", method=RequestMethod.POST)
    public String addProduct(@ModelAttribute @Valid Product product, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors found");
            return "addProduct";
        }    	
        
    	try {
			eStoreAdminService.addProduct(product);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "redirect:productList.html";  	
    }     
    
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
    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.DELETE)
    public @ResponseBody Boolean deleteProduct(String productId) throws ApplicationException, SystemException {
        return eStoreAdminService.deleteProduct(Long.valueOf(productId));
    }	
}
