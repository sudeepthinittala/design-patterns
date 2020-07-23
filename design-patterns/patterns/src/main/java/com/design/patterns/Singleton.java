package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Singleton 
{ 
	protected
	static final Logger LOGGER=LogManager.getLogger(App.class);

    private static Singleton obj;
    private Singleton(){
    	LOGGER.info("constructor of singleton ");
    } 
  
    public static Singleton getInstance() 
    { 
        if (obj==null) 
            obj = new Singleton(); 
        return obj; 
    } 
} 