package com.rsinc.webretail.b2c.estore.common.logging;

/* Copyright(c) 1997-2008 Satmetrix Systems, Inc. All rights reserved. */

import java.io.Serializable;

import com.rsinc.webretail.b2c.estore.common.util.SecurityContextUtils;
import com.rsinc.webretail.b2c.estore.data.entity.UserBean;

/**
 * 
 * Wrapper for apache common-logging framework
 * 
 * @author roshan.titus
 */
public class Logger implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -163974832619490911L;
	
	// Common logger interface
    public transient org.slf4j.Logger log = null;


    private Logger(org.slf4j.Logger log)
    {
        this.log = log;
    }

    protected static Logger getInstance(org.slf4j.Logger log)
    {
        Logger logger = new Logger(log);
        return logger;
    }

    /*
     * Logging properties
     */
    public boolean isDebugEnabled()
    {
        return log.isDebugEnabled();
    }

    public boolean isErrorEnabled()
    {
        return log.isErrorEnabled();
    }


    public boolean isInfoEnabled()
    {
        return log.isInfoEnabled();
    }

    public boolean isTraceEnabled()
    {
        return log.isTraceEnabled();
    }

    public boolean isWarnEnabled()
    {
        return log.isWarnEnabled();
    }

    /*
     * Logging methods
     */
    
    public void trace(Object message)
    {       
        trace(message, true);      
    }

    public void trace(Object message, Throwable t)
    {
        String msg = getExtenedMessage(String.valueOf(message));
        log.trace(msg, t);
    }

    public void debug(Object message)
    {
    	debug(message, true);         
    }

    public void debug(Object message, Throwable t)
    {
        String msg = getExtenedMessage(String.valueOf(message));
        log.debug(msg, t);
    }

    public void info(Object message)
    {
        info(message, true);       
    }

    public void info(Object message, Throwable t)
    {
        String msg = getExtenedMessage(String.valueOf(message));
        log.info(msg, t);
    }

    public void warn(Object message)
    {      
        warn(message, true);     
    }

    public void warn(Object message, Throwable t)
    {
        String msg = getExtenedMessage(String.valueOf(message));
        log.warn(msg, t);
    }

    public void error(Object message)
    {
        error(message, true);          
    }

    public void error(Object message, Throwable t)
    {
        String msg = getExtenedMessage(String.valueOf(message));
        log.error(msg, t);
    }
    
    //Private methods

    private void debug(Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(String.valueOf(message));
            log.debug(msg);
        } 
        else
        {
            log.debug(String.valueOf(message));
        }
    }
    
    private void trace(Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(String.valueOf(message));
            log.trace(msg);
        } 
        else
        {
            log.trace(String.valueOf(message));
        }
    }    
    
    private void info(Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(String.valueOf(message));
            log.info(msg);
        } 
        else
        {
            log.info(String.valueOf(message));
        }
    }
    
    private void warn(Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(String.valueOf(message));
            log.warn(msg);
        } 
        else
        {
            log.warn(String.valueOf(message));
        }
    }
    
    private void error(Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(String.valueOf(message));
            log.error(msg);
        } 
        else
        {
            log.error(String.valueOf(message));
        }
    }    
    
    private String getExtenedMessage(String message)
    {
        StringBuffer sb = new StringBuffer();
        UserBean user = SecurityContextUtils.getLoggedInUser();
        
        if(null != user)
        {
            sb.append("[User:"+ user + "] " + message);
        } 
        else 
        {
            sb.append("[User:] " + message);
        }
        
        return sb.toString();
    }
}
