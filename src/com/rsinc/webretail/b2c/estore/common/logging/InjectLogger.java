/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.logging;

/**
 * @author Roshan Titus
 *
 */
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
@Documented
public @interface InjectLogger {
}
