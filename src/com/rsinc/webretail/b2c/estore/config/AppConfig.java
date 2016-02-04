/**
 * 
 */
package com.rsinc.webretail.b2c.estore.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Roshan Titus
 *
 */
@Configuration
@Import(DatabaseConfig.class)
public class AppConfig {

	@Inject
	DatabaseConfig dataConfig;
	
//	@Bean
//    public MyBean myBean() {
//        // instantiate, configure and return bean ...
//    }
}
