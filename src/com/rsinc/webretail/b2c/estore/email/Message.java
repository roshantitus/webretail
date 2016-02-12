/**
 * 
 */
package com.rsinc.webretail.b2c.estore.email;

import java.util.Map;

/**
 * @author Roshan Titus
 *
 */
public class Message {
	
    /**
     * From address
     */
    private String from;

    /**
     * Target address
     */
    private String to;

    /**
     * Target CC address
     */
    private String cc;

    /**
     * Template identifier. 
     */
    private String templateId;

    /**
     * Name value pair for the variables in the template.
     */
    private Map<String, String> model;

    /**
     * Value for the subject
     */
    private String subject;

    /**
     *If the template is not provided, use this message. 
     */
    private String message;
    
    /**
     * Returns the from address
     * @return from address
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * Sets the from address
     * @param from from address
     */
    public void setFrom(String from)
    {
        this.from = from;
    }

    /**
     * Retrieves the target address
     */
    public String getTo()
    {
        return to;
    }

    public void setTo(String to)
    {
        this.to = to;
    }

    public String getCc()
    {
        return cc;
    }

    public void setCc(String cc)
    {
        this.cc = cc;
    }

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public Map<String, String> getModel()
    {
        return model;
    }

    public void setModel(Map<String, String> model)
    {
        this.model = model;
    }

    /**
     * Retrieves the subject description 
     */
    public String getSubject()
    {
        return subject;
    }

    /**
     * Replaces the old value of the subject 
     */
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }	

}
