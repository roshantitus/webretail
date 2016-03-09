/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
public class LoginController  extends BaseController{
	
//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);	

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String showLoginPage(Locale locale) {
        //return "login";
    	return "redirect:admin/dashboard.html";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login() {
        return "login";
    }    
   
}
