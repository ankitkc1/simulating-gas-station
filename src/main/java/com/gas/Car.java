package com.gas;

public class Car {
    private double arrivalTime; 
    private final double litresNeeded;

    /* constructor . 
    • 
    * The nwnber of litres required is a property of a car, so it belongs in 
    * this class. It is also something- the car "knows11 when it arrives, so it 
    * should be calculated in the constructor • 
    •  
    * The distribution of litres required is uniform between 10 and 60 • 
    */

    public Car(){
        litresNeeded = sim.litresNeededMin+ sim.litreStream.nextDouble() * sim.litresNeededRange; 
    }

    /* getArrivalTimei return the car's arrival time.  
    * @return double 
    */

    public double getArrivalTime (){
        return arrivalTime; 
    }

 
    /* getLitresNeeded: return the nwnber of litres of fuel needed by the car.  
    • @return double 
    */

    public double getLitresNeeded (){
        return litresNeeded; 
    }

    /**
    * setArrivalTime: set the car's arrival time.  
    * @param time double 
    */

    public void setArrivalTime (double time) { 
        arrivalTime = time;
    }

}
