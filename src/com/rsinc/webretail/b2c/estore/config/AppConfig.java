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
@Import(PersistenceJPAConfig.class)
public class AppConfig {

	@Inject
	PersistenceJPAConfig dataConfig;
	
//	@Bean
//    public UserDao<T> userDao() {
//        
//    }
}
