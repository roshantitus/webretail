/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.exception.application;

/**
 * @author Roshan Titus
 *
 */
public class ValidationException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8252702266576402390L;

	/**
	 * 
	 */
	public ValidationException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ValidationException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ValidationException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ValidationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ValidationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
