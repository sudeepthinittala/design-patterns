package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Chain
{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);
    public abstract void setNext(Chain nextInChain); 
    public abstract void process(Number request); 
} 
  
class Number 
{ 
    private int number; 
  
    public Number(int number) 
    { 
        this.number = number; 
    } 
  
    public int getNumber() 
    { 
        return number; 
    } 
  
} 
  
class NegativeProcessor implements Chain 
{ 
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() < 0) 
        { 
            LOGGER.info("NegativeProcessor : " + request.getNumber()); 
        } 
//        else
//        { 
//            nextInChain.process(request); 
//        } 
    } 
} 
  
class ZeroProcessor implements Chain 
{ 
      
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() == 0) 
        { 
            LOGGER.info("ZeroProcessor : " + request.getNumber()); 
        } 
//        else
//        { 
//            nextInChain.process(request); 
//        } 
    } 
} 
  
class PositiveProcessor implements Chain 
{ 
  
    private Chain nextInChain; 
  
    public void setNext(Chain c) 
    { 
        nextInChain = c; 
    } 
  
    public void process(Number request) 
    { 
        if (request.getNumber() > 0) 
        { 
            LOGGER.info("PositiveProcessor : " + request.getNumber()); 
        } 
//        else
//        { 
//            nextInChain.process(request); 
//        } 
    } 
} 