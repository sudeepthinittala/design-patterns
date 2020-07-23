package com.design.patterns;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOGGER=LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
    	ColorStore.getColor("blue").addColor(); 
        ColorStore.getColor("black").addColor(); 
        Bridge vehicle1 = new Car(new Produce(), new Assemble()); 
        vehicle1.manufacture(); 
        Sparrow sparrow = new Sparrow(); 
        ToyDuck toyDuck = new PlasticToyDuck();
        LOGGER.info("Sparrow..."); 
        sparrow.fly(); 
        sparrow.makeSound(); 
  
       LOGGER.info("ToyDuck..."); 
        toyDuck.squeak(); 
        Chain c1 = new NegativeProcessor(); 
        Chain c2 = new ZeroProcessor();
        c1.setNext(c2);  
        c1.process(new Number(90));
        IATCMediator atcMediator = new ATCMediator(); 
        Flight sparrow101 = new Flight(atcMediator); 
        Runway mainRunway = new Runway(atcMediator); 
        atcMediator.registerFlight(sparrow101); 
        atcMediator.registerRunway(mainRunway); 
        sparrow101.getReady(); 
        mainRunway.land(); 
        sparrow101.land();
        
    }
    
}
