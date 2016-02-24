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

import com.rsinc.webretail.b2c.estore.business.model.User;
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
public class ManageUsersController extends BaseController{

	@Inject
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageUsersController.class);
	
    @RequestMapping(value = "/admin/user/list/all", method = RequestMethod.GET)
    public @ResponseBody List<User> viewAllUsers() throws ApplicationException, SystemException {
        return eStoreAdminService.getAllUsers();
    }
    
    @RequestMapping(value = "/admin/user/view", method = RequestMethod.GET)
    public @ResponseBody User viewUser(String userId) throws ApplicationException, SystemException {
        return eStoreAdminService.getUser(Long.valueOf(userId));
    }    
    
    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
    public @ResponseBody Boolean editUser(User user) throws ApplicationException, SystemException {
        return eStoreAdminService.updateUser(user);
    }       
    
    @RequestMapping(value = "/admin/user/delete", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteUser(String userId) throws ApplicationException, SystemException {
        return eStoreAdminService.deleteUser(Long.valueOf(userId));
    }     
    
    @RequestMapping(value = "/admin/user/enable", method = RequestMethod.GET)
    public @ResponseBody Boolean enableUser(String userId) throws ApplicationException, SystemException {
        return eStoreAdminService.enableUser(Long.valueOf(userId));
    }
    
    @RequestMapping(value = "/admin/user/disable", method = RequestMethod.GET)
    public @ResponseBody Boolean disableUser(String userId) throws ApplicationException, SystemException {
        return eStoreAdminService.disableUser(Long.valueOf(userId));
    }    
   
}
