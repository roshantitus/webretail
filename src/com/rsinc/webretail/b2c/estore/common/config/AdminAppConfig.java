/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Roshan Titus
 *
 */
@Configuration
@Import(AppConfig.class)
@ComponentScan(basePackages = { "com.rsinc.webretail.b2c.estore.business.service" })
public class AdminAppConfig {



}
