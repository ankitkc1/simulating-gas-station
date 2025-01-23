package com.gas;

//import org.w3c.dom.events.Event;

public class EventList {
    // Listltem: the class for objects stored in the event list. 
    private class ListItem { 
        // The event list is a linked list, so each item contains a data field 
        // and a next item field. This is just a simple record structure, so 
        // we'll allow outsiders to access the fields directly instead of using 
        // get and set methods. 
        public com.gas.Event data; 
        public ListItem next; 
    }
    private ListItem firstEvent; 

    /* Constructor. 
    */

    public EventList () { 
        firstEvent =null; // happens automatically, but done explicitly 
            // here to clarify the 11empty list11 state. 
    } 
    
    public com.gas.Event getFirstEvent() { 
        return firstEvent != null ? firstEvent.data : null; 
    }
    /*
    * insert: add an event e to the event list in the appropriate place, 
    * prioritized by time. 
    * @param e aim.Event 
    */

    public void insert (com.gas.Event e) { 
        // Create the item to go on the event list. 
        ListItem item = new ListItem(); 
        item.data = e; 

        // Find the appropriate place for the item in the event list, 
        // and put it there, 
        final double time= e.getTime(); 
        if (firstEvent == null || time < firstEvent.data.getTime()) { 
            item.next = firstEvent; 
            firstEvent = item; 
        }
        else { 
            ListItem behind = firstEvent; 
            ListItem ahead = firstEvent.next; 
            while (ahead != null && ahead.data.getTime() <= time) { 
                behind = ahead; 
                ahead = ahead.next; 
            }
            behind.next = item; 
            item.next = ahead; 
        }
    }
    /** 
    * takeNextEvent: remove the item at the head of the event list and 
    * return it. 
    * @return aim.Event 
    */
    public com.gas.Event takeNextEvent () { 
    // precondition1 firstEvent != null 
        if (firstEvent == null) { 
            System.out.println("Error! ran out of events"); 
            return null; 
        }

        com.gas.Event eventToReturn = firstEvent.data; 
        firstEvent = firstEvent.next; 
        return eventToReturn; 
        }
}

    /** 
    * Arrival: the class representing arrival events. 
    */

    class Arrival extends com.gas.Event { 
    
    /** 
    * Constructor. 
    * @p~ram time double 
    */

    public Arrival (double time) { 
    super (time) ;
    }

    /** 
    * doesCarBalk: decide whether a car should balk. 
    * Deciding whether to balk is an activity that forms part of the arrival 
    * event, so this method belongs among the event routines.
    *The probability that a car leaves'·without buying gas {i.e., balks) grows 
    * larger as the queue length gets larger, and grows smaller when the car 
    * requires a greater number of litres of gas, so that: 
    * 
    (1) there is no balking if the queue length is zero, and 
    • (2) otherwise, the probability of NOT balking is 
    • 
    (40 + litres)/(25 * (3 + queueLength)) 
    * @return boolean 
    * @param litres double 
    * @param queueLength int 
    */

    private boolean doesCarBalk (double litres, int queueLength) { 
        return queueLength > 0 && (sim.balkingStream.nextDouble() > (sim.balkA +litres)/(sim.balkB * (sim.balkC + queueLength)));
         
        /* interarrivalTime: the time uµtil the next arrival, from an exponential 
        • distribution. 
        * @return double 
        */
    }

    private double interarrivalTime (){ 
        return - sim.meanInterarrivalTime * Math.log (sim.arrivalStream.nextDouble()); 
    }

    /** 
    * makeitHappen: arrival event routine. 
    */

    @Override
    public void makeItHappen() { 
        // Create and initialize a new auto record. 
        Car arrivingCar =new Car (); 
        sim.stats.countArrival(); 
        final double litres= arrivingCar.getLitresNeeded(); 
        if (doesCarBalk (litres, sim.carQueue.getQueueSize())) 
            sim.stats.accumBalk (litres); 
        else { 
            arrivingCar.setArrivalTime (sim.simulationTime); 
            if (sim.pumpStand.aPumpIsAvailable()) 
                sim.pumpStand.takeAvailablePump().startService (arrivingCar);
            else 
                sim.carQueue.insert (arrivingCar); 
        } 
        // Schedule the next arrival, reusing the current event object. 
        setTime(sim.simulationTime + interarrivalTime());
        sim.eventList.insert(this);
    } 
}


    /* Departure1 the class representing departure events. 
    */

    class Departure extends com.gas.Event{
        private Pump pump;
    /** 
    * Constructor.
    *@param time double
    */
    public Departure(double time) { 
        super(time);
    }
 
    /**
        * makeitHappen: departure event routine • 

    */
    @Override
    public void makeItHappen(){
        // precondition: pump I= null && pump.getCarinService 1= null 
        
        // Identify the departing car and collect statistics. 
        Car departingCar = pump.getCarInService(); 
        sim.stats.accumSale (departingCar.getLitresNeeded()); 
        
        //The car vanishes and the pump is free; can we serve another car? 
        if(sim.carQueue.getQueueSize() > 0)
            pump.startService(sim.carQueue.takeFirstCar()); 
        else 
            sim.pumpStand.releasePump(pump); 
    } 

        /** 
            *setPump: assign a pump to this arrival. 
        * @param pump sim.Pump 
        */

    public void setPump (Pump pump) { 
        this.pump = pump; 
    }
} 

    /* 
    * Report1 the class representing reporting events. 
    */

class Report extends com.gas.Event { 
    /* 
    * Constructor. 
    * @param time double 
    */

    public Report(double time){
        super(time); 
    } 

    /**
    * makeitHappen: interim reporting event routine • 
    */
    @Override
    public void makeItHappen() { 
        sim.stats.snapshot (); 

        // Schedule the next interim report. 
        setTime (sim.simulationTime + sim.reportInterval); 
        sim.eventList.insert(this); 
    }
}

// * EndOfSimulation; the class represent~na the final event that stops the 
// * simulation 

class EndOfSimulation extends com.gas.Event { 
    /**
    * Constructor. 
    * @param time double 
    */

    public EndOfSimulation(double time){
        super (time); 
    }

    /**
    * makeltHappen: end of simulation event routine 
    */

    @Override
    public void makeItHappen(){ 
        sim.stats.snapshot (); 
    } 
}
