/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.logging;

/**
 * @author Roshan Titus
 *
 */
import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

public class LoggerInjector implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException 
    {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException 
    {
        ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() 
        {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException 
            {
                // make the field accessible if defined private
                ReflectionUtils.makeAccessible(field);
                if (field.getAnnotation(InjectLogger.class) != null) 
                {
                    Logger log = LoggerFactory.getLogger(bean.getClass());
                    field.set(bean, log);
                }
            }
        });
        return bean;
    }
}