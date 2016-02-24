/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.util;

/**
 * @author Roshan Titus
 *
 */
public class BeanUtils {

	/**
	 * 
	 */
	private BeanUtils() { }
	
	public static void setproperty(Object bean, String property, Object value)
	{
		
	}
	
	public static Object getProperty(Object bean, String property)
	{
		return null;
	}

	/**
	 * @param categoryBean
	 * @param categoryBeanFromDB
	 */
	public static void copyProperties(Object source,
			Object target) {
		
		org.springframework.beans.BeanUtils.copyProperties(source, target);
		
	}

}
