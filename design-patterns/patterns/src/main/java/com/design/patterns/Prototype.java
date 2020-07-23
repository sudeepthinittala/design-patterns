package com.design.patterns;
import java.util.HashMap; 
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 
  
  
abstract class Prototype implements Cloneable 
{ 
	protected
	static final Logger LOGGER=LogManager.getLogger(App.class);

    protected String colorName; 
       
    abstract void addColor(); 
       
    public Object clone() 
    { 
        Object clone = null; 
        try 
        { 
            clone = super.clone(); 
        }  
        catch (CloneNotSupportedException e)  
        { 
            e.printStackTrace(); 
        } 
        return clone; 
    } 
} 
  
class blueColor extends Prototype 
{ 
    public blueColor()  
    { 
        this.colorName = "blue"; 
    } 
   
    @Override
    void addColor()  
    { 
        System.out.println("Blue color added"); 
    } 
      
} 
  
class blackColor extends Prototype{ 
   
    public blackColor() 
    { 
        this.colorName = "black"; 
    } 
   
    @Override
    void addColor()  
    { 
        LOGGER.info("Black color added"); 
    } 
} 
   
class ColorStore { 
   
    private static Map<String, Prototype> colorMap = new HashMap<String, Prototype>();  
       
    static 
    { 
        colorMap.put("blue", new blueColor()); 
        colorMap.put("black", new blackColor()); 
    } 
       
    public static Prototype getColor(String colorName) 
    { 
        return (Prototype) colorMap.get(colorName).clone(); 
    } 
} 