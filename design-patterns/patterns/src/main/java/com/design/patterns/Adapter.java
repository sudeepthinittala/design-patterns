package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Adapter
{
    static final Logger LOGGER=LogManager.getLogger(App.class);

    public void fly(); 
    public void makeSound(); 
} 
  
class Sparrow implements Adapter
{ 
    public void fly() 
    { 
    	LOGGER.info("Flying"); 
    } 
    public void makeSound() 
    { 
        LOGGER.info("Chirp Chirp"); 
    } 
} 
  
interface ToyDuck 
{ 
    static final Logger LOGGER=LogManager.getLogger(App.class);

    public void squeak(); 
} 
  
class PlasticToyDuck implements ToyDuck 
{ 
    public void squeak() 
    { 
        LOGGER.info("Squeak"); 
    } 
} 
  
class BirdAdapter implements ToyDuck 
{  
    Adapter bird; 
    public BirdAdapter(Adapter bird) 
    { 
        
        this.bird = bird; 
    } 
  
    public void squeak() 
    { 
        bird.makeSound(); 
    } 
} 
