package com.gas;

public class CarQueue {

    // Queueitem: the class for objects stored in the car queue. 
    private class Queueitem { 
        //  The car queue is a linked list, so each item contains a data field 
        //  and a "next item" field. This is just a simple record structure, so 
        //  we'll allow outsiders to access the fields directly instead of using 
        //  get and set methods. 
        public Car data; 
        public Queueitem next;
    }

    private Queueitem firstWaitingCar; 
    private Queueitem lastWaitingCar; 
    private int queueSize; 
    private double totalEmptyQueueTime; 

    /**
    * Constructor. 
    */ 

    public CarQueue () { 
        firstWaitingCar = null; 
        lastWaitingCar = null; 
        queueSize = 0; 
        totalEmptyQueueTime = 0; 
    }
    /**
    getEmptyTime: return the total time the car queue has been empty. 
    * @return double 
    */

    public double getEmptyTime () { 
        if (queueSize > 0) 
            return totalEmptyQueueTime; 
        else 
            return totalEmptyQueueTime + sim.simulationTime; 
        } 

    /**
    * getQueueSize: return the number of cars in the car queue. 
    * @return int 
    */

    public int getQueueSize () { 
        return queueSize; 
    }
    /**
    * insert: put a newly-arrived car into the car queue. 
    * @param newestcar aim.car 
    */

    public void insert(Car newestCar) {
        Queueitem item= new Queueitem(); 
        item.data = newestCar; 
        item.next = null; 

        if (lastWaitingCar == null) { 
            //the queue is empty 
            firstWaitingCar = item; 
            totalEmptyQueueTime += sim.simulationTime;
        }
        else {
            // the queue already had at least one car in it 
            lastWaitingCar.next = item; 
        }

        lastWaitingCar = item;
        queueSize += 1; 
    }

    /** 
        * takeFirstCar; remove first car from car queue and return it. 
        * @return aim.car 
    */
    
    public Car takeFirstCar (){
        //precondition: queueSize > O && firstWaitingCar l= null 
        if (queueSize <= 0 || firstWaitingCar == null){
            System.out.println ("Error! car queue unexpectedly empty"); 
            return null; 
        }
        Car carToReturn = firstWaitingCar.data; 
        queueSize--; 
        firstWaitingCar = firstWaitingCar.next; 

        if (firstWaitingCar == null){
            // empty queue; update the end of the queue, and start 
            // counting empty queue time 
            lastWaitingCar = null; 
            totalEmptyQueueTime -= sim.simulationTime; 
        }
        
        return carToReturn; 
    }
}
