/**
 * 
 */
package com.rsinc.webretail.b2c.estore.config;

import java.util.Properties;

import javax.inject.Inject;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;

import com.rsinc.webretail.b2c.estore.email.MailManager;
import com.rsinc.webretail.b2c.estore.email.MailSender;

/**
 * @author Roshan Titus
 *
 */
@Configuration
@Import(DataConfig.class)
@ComponentScan({ "com.rsinc.webretail.b2c.estore.manager" })
@PropertySource({ "classpath:/mail-config.properties" })
public class AppConfig {

	@Inject
	DataConfig dataConfig;
	   
//	@Bean
//    public UserDao<T> userDao() {
//        
//    }
	
	@Bean
    public JavaMailSender mailSender() {
		MailSender mailSender = new MailSender();

		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		mailSender.setJavaMailProperties(getMailProperties());

        return mailSender;
    }
	
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true");
        return properties;
    }	
    
	@Bean
    public VelocityEngine velocityEngine(){
		
		VelocityEngineFactoryBean velocityFactory = new VelocityEngineFactoryBean();
		velocityFactory.setVelocityProperties(getVelocityProperties());
		return (VelocityEngine) velocityFactory.getObject();
	}
    
    private Properties getVelocityProperties() {
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return properties;
    }	    
    
    @Bean
    public MailManager mailManager()
    {
    	MailManager mailManager = new MailManager();
    	mailManager.setMailSender(mailSender());
    	mailManager.setVelocityEngine(velocityEngine());
    	return mailManager;
    }
    
	/*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
	 * Remove this bean if you are not using @Value annotations for injecting properties.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}    
    
    @Value("${email.host}")
    private String host;

    @Value("${email.port}")
    private Integer port;
    
    @Value("${email.username}")
    private String username;
    
    @Value("${email.password}")
    private String password;    
}
