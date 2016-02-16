package com.rsinc.webretail.b2c.estore.logging;

/* Copyright(c) 1997-2008 Satmetrix Systems, Inc. All rights reserved. */

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;

import com.rsinc.webretail.b2c.estore.entity.UserBean;
import com.rsinc.webretail.b2c.estore.util.SecurityContextUtils;

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
    public transient Log log = null;


    private Logger(Log log)
    {
        this.log = log;
    }

    protected static Logger getInstance(Log log)
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

    public boolean isFatalEnabled()
    {
        return log.isFatalEnabled();
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
    
    public void trace(HttpSession session, Object message)
    {
        if (null != session)
        {        
            trace(session, message, true);
        }
        else
        {
            log.trace(message);
        }        
    }

    public void trace(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.trace(msg);
        } 
        else
        {
            log.trace(message);
        }
    }

    public void trace(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.trace(msg, t);
    }

    public void debug(HttpSession session, Object message)
    {
        if (null != session)
        {        
            debug(session, message, true);
        }
        else
        {
            log.debug(message);
        }          
    }

    public void debug(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.debug(msg);
        } 
        else
        {
            log.debug(message);
        }
    }

    public void debug(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.debug(msg, t);
    }

    public void info(HttpSession session, Object message)
    {
        if (null != session)
        {        
            info(session, message, true);
        }
        else
        {
            log.info(message);
        }         
    }

    public void info(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.info(msg);
        } 
        else
        {
            log.info(message);
        }
    }

    public void info(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.info(msg, t);
    }

    public void warn(HttpSession session, Object message)
    {
        if (null != session)
        {        
            warn(session, message, true);
        }
        else
        {
            log.warn(message);
        }          
    }

    public void warn(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.warn(msg);
        } 
        else
        {
            log.warn(message);
        }
    }

    public void warn(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.warn(msg, t);
    }

    public void error(HttpSession session, Object message)
    {
        if (null != session)
        {        
            error(session, message, true);
        }
        else
        {
            log.error(message);
        }           
    }

    public void error(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.error(msg);
        } 
        else
        {
            log.error(message);
        }
    }

    public void error(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.error(msg, t);
    }

    public void fatal(HttpSession session, Object message)
    {
        if (null != session)
        {        
            fatal(session, message, true);
        }
        else
        {
            log.fatal(message);
        }          
    }

    public void fatal(HttpSession session, Object message, boolean appendScontext)
    {
        if (appendScontext)
        {
            String msg = getExtenedMessage(session, String.valueOf(message));
            log.fatal(msg);
        } 
        else
        {
            log.fatal(message);
        }
    }

    public void fatal(HttpSession session, Object message, Throwable t)
    {
        String msg = getExtenedMessage(session, String.valueOf(message));
        log.fatal(msg, t);
    }

    // TODO integrate this method with Security context to get the enterprise and user info
    public String getExtenedMessage(HttpSession session, String message)
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
