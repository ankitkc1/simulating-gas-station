package com.gas;

public abstract class Event {
    private double time;
    public Event (double time) { 
        this.time = time; 
    }
    /* 
    * getTime: return the time of the event. 
    * @return double 
    */ 
    public double getTime () { 
    return time; 
    }
    
    /**
    * makeitHappen: the event routine. 
    */

    public abstract void makeItHappen (); 
    /**
    * setTime: set the time of the event. 
    * @param time double 
    */

    public void setTime (double time) { 
    this.time = time; 
    }


}
