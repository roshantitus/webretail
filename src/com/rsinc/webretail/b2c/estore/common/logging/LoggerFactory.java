package com.rsinc.webretail.b2c.estore.common.logging;

/* Copyright(c) 1997-2008 Satmetrix Systems, Inc. All rights reserved. */

import java.io.Serializable;
import java.util.WeakHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * LoggerFactory to create apache common logger.
 * 
 * 
 * @author roshan.titus
 */
public class LoggerFactory implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6939041459898136008L;
	
	// logger holder
    private static WeakHashMap<String, Logger> instances = new WeakHashMap<String, Logger>();
    // locking purpose
    private static Object lock = new Object();

    /*
     * Logger user should call this method
     */
    
    @SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clzz)
    {
        return getInstance(clzz.getName());
    }

    /*
     * Unless a specific reason logger user should not call this method
     */
    public static Logger getLogger(String name)
    {
        return getInstance(name);
    }

    /*
     * Internal usage to create the logger
     */
    protected static Logger getInstance(String name)
    {
        Logger logger = instances.get(name);
        if (null == logger)
        {
            Log instance = LogFactory.getLog(name);
            logger = Logger.getInstance(instance);
            synchronized (lock)
            {
                instances.put(name, logger);
            }
        }
        return logger;
    }

    /*
     * When the logger exceeds the expected memory, we can use this method to
     * clear the contents.
     * 
     */
    public void release()
    {
        instances.clear();
    }

    public String toString()
    {
        return null;
    }
}
