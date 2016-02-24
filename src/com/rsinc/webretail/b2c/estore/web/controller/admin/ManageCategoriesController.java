/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsinc.webretail.b2c.estore.business.model.Category;
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
public class ManageCategoriesController extends BaseController{


	@Inject
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageCategoriesController.class);
	
	
    @RequestMapping(value = "/admin/category/list/all", method = RequestMethod.GET)
    public @ResponseBody List<Category> viewAllCategories() throws ApplicationException, SystemException {
        return eStoreAdminService.getAllCategories();
    }
    
    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
    public @ResponseBody Long addCategory(Category category) throws ApplicationException, SystemException {
        return eStoreAdminService.addCategory(category);
    }	
    
    @RequestMapping(value = "/admin/category/view", method = RequestMethod.GET)
    public @ResponseBody Category viewCategory(String categoryId) throws ApplicationException, SystemException {
        return eStoreAdminService.getCategory(Long.valueOf(categoryId));
    }    
    
    @RequestMapping(value = "/admin/category/edit", method = RequestMethod.POST)
    public @ResponseBody Boolean editCategory(Category category) throws ApplicationException, SystemException {
        return eStoreAdminService.updateCategory(category);
    }       
    
    @RequestMapping(value = "/admin/category/delete", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteCategory(String categoryId) throws ApplicationException, SystemException {
        return eStoreAdminService.deleteCategory(Long.valueOf(categoryId));
    }   	
}
