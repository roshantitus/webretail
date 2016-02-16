/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsinc.webretail.b2c.estore.domain.User;
import com.rsinc.webretail.b2c.estore.service.EStoreAdminService;

/**
 * @author Roshan Titus
 *
 */
@Controller
public class UserController {

	@Autowired
	private EStoreAdminService eStoreAdminService;
	
    /**
    * Rest web service
    */
    @RequestMapping(value = "/admin/usersList", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() {
        return eStoreAdminService.getAllUsers();
    }

}
