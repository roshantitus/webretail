/**
 * 
 */
package com.rsinc.webretail.b2c.estore.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rsinc.webretail.b2c.estore.config.AppConfig;

/**
 * @author Roshan Titus
 *
 */
public class AppConfigUtils {
	
	private static AnnotationConfigApplicationContext ctx = null;
	
//	static
//	{
//		ctx = new AnnotationConfigApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//	}
	
	private AppConfigUtils(){}
	
	public static <T> Object getBean(Class<T> className)
	{
		return ctx.getBean(className);
	}

	public static Object getBean(String beanName)
	{
		return ctx.getBean(beanName);
	}	
}
