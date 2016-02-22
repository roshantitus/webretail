/**
 * 
 */
package com.rsinc.webretail.b2c.estore.common.email;

import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.rsinc.webretail.b2c.estore.common.exception.system.EmailDeliveryFailureSystemException;
import com.rsinc.webretail.b2c.estore.common.util.Constants;



/**
 * @author Roshan Titus
 *
 */
public class MailManager{

	/**
	 * 
	 */
	private JavaMailSender mailSender;
	
    private VelocityEngine velocityEngine;
    
    
	public MailManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void sendMessage(MailMessage mailMessage) throws EmailDeliveryFailureSystemException
	{
		try {
			mailSender.send(new MimeMessagePreparator() {
				
			public void prepare(MimeMessage mimeMessage) throws Exception
			{			
			    MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "utf-8");
			    String toString = mailMessage.getTo();
			    String[] toStringArray;
			    String ccString = mailMessage.getCc();
			    String[] ccStringArray;

			    if (toString != null && !"".equals(toString))
			    {
			        if (toString.contains(Constants.SEMICOLON_SYMBOL))
			        {
			            toStringArray = toString.split(Constants.SEMICOLON_SYMBOL);
			            message.setTo(toStringArray);
			        }
			        else if (toString.contains(Constants.COMMA_SYMBOL))
			        {
			            toStringArray = toString.split(Constants.COMMA_SYMBOL);
			            message.setTo(toStringArray);
			        }
			        else
			        {
			            message.setTo(toString);
			        }
			    }
			    if (ccString != null && !"".equals(ccString))
			    {
			        if (ccString.contains(Constants.SEMICOLON_SYMBOL))
			        {
			            ccStringArray = ccString.split(Constants.SEMICOLON_SYMBOL);
			            message.setCc(ccStringArray);
			        }
			        else if (ccString.contains(Constants.COMMA_SYMBOL))
			        {
			            ccStringArray = ccString.split(Constants.COMMA_SYMBOL);
			            message.setCc(ccStringArray);
			        }
			        else
			        {
			            message.setCc(ccString);
			        }
			    }
			    message.setFrom(mailMessage.getFrom());
			    if (mailMessage.getSubject() == null)
			    {
			        message.setSubject("");
			    }
			    else
			    {
			        message.setSubject(mailMessage.getSubject());
			    }

			    String templateId = mailMessage.getTemplateId();
			    String body = "";
			    if (templateId != null && templateId.length() > 0)
			    {
			    	body = getMessage(mailMessage.getTemplateId(), mailMessage
			                .getModel());
			    }
			    else if (mailMessage.getMessage() != null)
			    {
			        body = mailMessage.getMessage();
			    }
			    
			    switch(mailMessage.getType()) {
			    case HTML:
			        message.setText(body, true);
			        break;
			    default:
			        message.setText(body);
			        break;            
			    }
			}});
		} catch (MailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EmailDeliveryFailureSystemException();
		}
	}
	
    /**
     * Constructs the message by substituting the model values in the given
     * template name. The template file is loaded from the path.
     * 
     * @param templateId
     *            template identifier
     * @param model
     *            name value pair for all the parameters in the template
     * @return actual notification message
     */
    public String getMessage(String templateId, Map<String, Object> model)
    {
        String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, templateId, model);
        return text;
    }

	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}	
    
    

}
