package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ATCMediator implements IATCMediator  
{ 
    private Flight flight; 
    private Runway runway; 
    public boolean land; 
    static final Logger LOGGER=LogManager.getLogger(App.class);
    public void registerRunway(Runway runway)  
    { 
        this.runway = runway; 
    } 
  
    public void registerFlight(Flight flight)  
    { 
        this.flight = flight; 
    } 
  
    public boolean isLandingOk()  
    { 
        return land; 
    } 
  
    public void setLandingStatus(boolean status)  
    { 
        land = status; 
    } 
} 
  
interface Command  
{ 
    static final Logger LOGGER=LogManager.getLogger(App.class);

    void land(); 
} 
  
interface IATCMediator 
{ 
    static final Logger LOGGER=LogManager.getLogger(App.class);

  
    public void registerRunway(Runway runway); 
  
    public void registerFlight(Flight flight); 
  
    public boolean isLandingOk(); 
  
    public void setLandingStatus(boolean status); 
} 
  
class Flight implements Command  
{ 
    private IATCMediator atcMediator; 
  
    public Flight(IATCMediator atcMediator)  
    { 
        this.atcMediator = atcMediator; 
    } 
  
    public void land()  
    { 
        if (atcMediator.isLandingOk())  
        { 
            System.out.println("Successfully Landed."); 
            atcMediator.setLandingStatus(true); 
        } 
        else
            System.out.println("Waiting for landing."); 
    } 
  
    public void getReady()  
    { 
        System.out.println("Ready for landing."); 
    } 
  
} 
  
class Runway implements Command  
{ 
    private IATCMediator atcMediator; 
  
    public Runway(IATCMediator atcMediator)  
    { 
        this.atcMediator = atcMediator; 
        atcMediator.setLandingStatus(true); 
    } 
  
    public void land()  
    { 
        LOGGER.info("Landing permission granted."); 
        atcMediator.setLandingStatus(true); 
    } 
  
} 

