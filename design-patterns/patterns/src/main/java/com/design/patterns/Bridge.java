package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class Bridge {
	protected
	static final Logger LOGGER=LogManager.getLogger(App.class);

    protected Workshop workShop1; 
    protected Workshop workShop2; 
  
    protected Bridge(Workshop workShop1, Workshop workShop2) 
    { 
        this.workShop1 = workShop1; 
        this.workShop2 = workShop2; 
    } 
  
    abstract public void manufacture(); 
}
class Car extends Bridge{ 
    public Car(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        LOGGER.info("Car "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
} 
  
// Refine abstraction 2 in bridge pattern 
class Bike extends Bridge { 
    public Bike(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        System.out.print("Bike "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
}
interface Workshop 
{ 
    abstract public void work(); 
}
class Produce implements Workshop { 
    public void work() 
    { 
        System.out.print("Produced"); 
    } 
}
class Assemble implements Workshop { 
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Assembled."); 
    } 
} 