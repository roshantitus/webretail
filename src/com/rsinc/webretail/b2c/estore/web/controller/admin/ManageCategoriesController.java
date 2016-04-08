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

import com.rsinc.webretail.b2c.estore.business.domain.entity.CategoryBean;
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
public class ManageCategoriesController extends BaseController{


	@Inject
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageCategoriesController.class);
	
    @RequestMapping(value="/admin/categoryList.html", method=RequestMethod.GET)
    public String viewAllCategories(Locale locale) {
        return "categoryList";
    }
	
	//REST APIS
    @RequestMapping(value = "/admin/category/list/all/{pageSize}/{page}", method = RequestMethod.GET)
    public @ResponseBody List<CategoryBean> getAllCategories(@PathVariable String pageSize, @PathVariable String page) throws ApplicationException, SystemException {
    	ResultLoadCriteria resultLoadCriteria = new ResultLoadCriteria();
    	Integer first = (Integer.valueOf(page) - 1) * Integer.valueOf(pageSize);
    	resultLoadCriteria.setFirst(first);
    	resultLoadCriteria.setPageSize(Integer.valueOf(pageSize));
        return eStoreAdminService.getAllCategories(resultLoadCriteria);
    }
    
    @RequestMapping(value = "/admin/category/count/all/", method = RequestMethod.GET)    
    public @ResponseBody Long getTotalCategoryCount() throws ApplicationException, SystemException {
        return eStoreAdminService.getTotalCategoryCount();
    }    

    @RequestMapping(value="/admin/editCategory.html", method=RequestMethod.GET)
    public ModelAndView showEditCategoryForm(String categoryId) throws ApplicationException, SystemException {
    	
    	ModelAndView modelAndView = new ModelAndView("editCategory");
    	modelAndView.addObject("categoryList", eStoreAdminService.getAllCategories());
    	modelAndView.addObject("category", eStoreAdminService.getCategory(Long.valueOf(categoryId)));
        return modelAndView;
    }    
    
    @RequestMapping(value="/admin/editCategory.html", method=RequestMethod.POST)
    public String editCategory(@ModelAttribute("category") @Valid CategoryBean category, BindingResult bindingResult, Model model) throws ApplicationException, SystemException {
    	
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors found " + bindingResult.getAllErrors());
            return "editCategory";
        } 
        
    	try {
			eStoreAdminService.updateCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:categoryList.html";
    }     
    
    @RequestMapping(value="/admin/addCategory.html", method=RequestMethod.GET)
    public ModelAndView showAddCategoryForm() throws ApplicationException, SystemException {
    	
    	ModelAndView modelAndView = new ModelAndView("addCategory");
    	modelAndView.addObject("categoryList", eStoreAdminService.getAllCategories());
    	modelAndView.addObject("category", new CategoryBean());
        return modelAndView;    	
    }   
    
    @RequestMapping(value="/admin/addCategory.html", method=RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") @Valid CategoryBean category, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            logger.info("Validation errors found " + bindingResult.getAllErrors());
            return "addCategory";
        } 
        
    	try {
			eStoreAdminService.addCategory(category);
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return "redirect:categoryList.html";  	
    }    
        
//    
//    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
//    public @ResponseBody Long addCategory(CategoryBean category) throws ApplicationException, SystemException {
//        return eStoreAdminService.addCategory(category);
//    }	
//    
//    @RequestMapping(value = "/admin/category/view", method = RequestMethod.GET)
//    public @ResponseBody CategoryBean viewCategory(String categoryId) throws ApplicationException, SystemException {
//        return eStoreAdminService.getCategory(Long.valueOf(categoryId));
//    }    
//    
//    @RequestMapping(value = "/admin/category/edit", method = RequestMethod.POST)
//    public @ResponseBody Boolean editCategory(CategoryBean category) throws ApplicationException, SystemException {
//        return eStoreAdminService.updateCategory(category);
//    }       
//    
    @RequestMapping(value = "/admin/category/delete", method = RequestMethod.DELETE)
    public @ResponseBody Boolean deleteCategory(String categoryId) throws ApplicationException, SystemException {
        return eStoreAdminService.deleteCategory(Long.valueOf(categoryId));
    }   	
}
