/**
 * 
 */
package com.rsinc.webretail.b2c.estore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Roshan Titus
 *
 */
@Controller
public class IndexController {

    @RequestMapping(value="/")
    public String index() {
        return "index";
    }
}
