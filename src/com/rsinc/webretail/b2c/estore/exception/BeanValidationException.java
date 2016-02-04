/**
 * 
 */
package com.rsinc.webretail.b2c.estore.exception;

/**
 * @author Roshan Titus
 *
 */
public class BeanValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8252702266576402390L;

	/**
	 * 
	 */
	public BeanValidationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public BeanValidationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public BeanValidationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BeanValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public BeanValidationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
