package com.rsinc.webretail.b2c.estore.util;

/* Copyright(c) 1997-2008 Satmetrix Systems, Inc. All rights reserved. */

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * This class is a utility class to read from the configuration file app-config.properties
 * 
 * 
 * @author Roshan Titus
 */
public class ResourceBundleUtils 
{    
    private static final String BUNDLE_NAME = "app-config";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private ResourceBundleUtils() 
    {
        //empty
    }

    public static String getString(String key) 
    {       
        try 
        {
            return RESOURCE_BUNDLE.getString(key);            
        } 
        catch (MissingResourceException e) 
        {
            return '!' + key + '!';
        }
    }
}