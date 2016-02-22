/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rsinc.webretail.b2c.estore.business.model.User;
import com.rsinc.webretail.b2c.estore.business.service.EStoreAdminService;
import com.rsinc.webretail.b2c.estore.common.exception.application.ApplicationException;
import com.rsinc.webretail.b2c.estore.common.exception.system.SystemException;
import com.rsinc.webretail.b2c.estore.common.logging.Logger;
import com.rsinc.webretail.b2c.estore.common.logging.LoggerFactory;
import com.rsinc.webretail.b2c.estore.common.util.Constants;

/**
 * @author Roshan Titus
 *
 */
@Controller
public class ManageUsersController {

	@Autowired
	private EStoreAdminService eStoreAdminService;
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(ManageUsersController.class);
	
    /**
    * Rest web service
     * @throws SystemException 
     * @throws ApplicationException 
    */
    @RequestMapping(value = "/admin/usersList", method = RequestMethod.GET)
    public @ResponseBody List<User> getAllUsers() throws ApplicationException, SystemException {
    	logger.info("getAllUsers()");
        return eStoreAdminService.getAllUsers();
    }
    
    @ExceptionHandler(ApplicationException.class)
    public ModelAndView handleApplicationException(HttpServletRequest req, Exception exception) {
      logger.error("Request: " + req.getRequestURL() + " raised " + exception);

      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", exception);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName(Constants.DEFAULT_ERROR_VIEW);
      return mav;
    }    

    @ExceptionHandler(SystemException.class)
    public ModelAndView handleSystemException(HttpServletRequest req, Exception exception) {
      logger.error("Request: " + req.getRequestURL() + " raised " + exception);

      ModelAndView mav = new ModelAndView();
      mav.addObject("exception", exception);
      mav.addObject("url", req.getRequestURL());
      mav.setViewName(Constants.DEFAULT_ERROR_VIEW);
      return mav;
    }     
}
