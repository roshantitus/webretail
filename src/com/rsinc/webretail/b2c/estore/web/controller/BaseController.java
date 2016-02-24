/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class BaseController {

//	@InjectLogger
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);
	
    //Exception handling
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
