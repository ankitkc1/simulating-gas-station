package com.gas;

public class Pump {

    private Car carInService; 
    /**
    * getCarinservice; return the car currently being served by the pump.  
    * @return aim.Car 
    */

    public Car getCarInService (){ 
        return carInService;
    }

    /**
    * serviceTimei determine how long the service will t~ke. 
    * This is a property of the pump-car combination1 so the method could have 
    * been in the Car class if the appropriate information were available there . 
    • 
    * Service times have a normal distribution with a mean given by a constant 
    * base plus an amount of time per litre1 and with a fixed standard 
    * deviation. 
    * @return double 
    */
    
    private double serviceTime () { 
        if (carInService == null) { 
            System.out.println ("Error! no car in service when expected"); 
            return -1.0; 
        } 

        return sim.serviceTimeBase
            + sim.serviceTimePerLitre * carInService.getLitresNeeded() 
            + sim.serviceTimeSpread * sim.serviceStream.nextGaussian(); 
    }

    /** 
    * startservice: the start-of-service event routine. 
    * Connects the car to this pump, and dete:cmines when the service will stop. 
    * @pararn car aim.Car 
    */
    public void startService (Car car) { 
        // precondition• Sim.pumpStand.aPumpisAvailable(), 
        // Match the auto to an available pump. 
        carInService = car; 
        final double pumpTime = serviceTime(); 
        
        // Collect statistics. 
        sim.stats.accumWaitingTime (sim.simulationTime - carInService.getArrivalTime()); 
        sim.stats.accumServiceTime (pumpTime); 
        
        // Schedule departure of car from this pump. 
        Departure dep =new Departure (sim.simulationTime + pumpTime); 
        dep.setPump (this); 
        sim.eventList.insert (dep);
    }
}
