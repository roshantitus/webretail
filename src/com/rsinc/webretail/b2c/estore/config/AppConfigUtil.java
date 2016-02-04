/**
 * 
 */
package com.rsinc.webretail.b2c.estore.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Roshan Titus
 *
 */
public class AppConfigUtil {
	
	private static AnnotationConfigApplicationContext ctx = null;
	
	static
	{
		ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
	}
	
	public static Object getBean(Class className)
	{
		return ctx.getBean(className);
	}

	public static Object getBean(String beanName)
	{
		return ctx.getBean(beanName);
	}	
}
