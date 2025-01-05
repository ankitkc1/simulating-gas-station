package com.gas;

public class PumpStand {
    private Pump[] pumps; // an array of pumps 
    private int numPumps;
    private int topPump; 
    
    /** 
    * Constructor; build a PumpStand of nwnPumps pumps, and make all of 
    * them available. 
    * @param numPumps int 
    */

    public PumpStand (int numPumps) {
        if (numPumps < 1) { 
            System.out.println ("Error! pump stand needs more than O pumps" ); 
            return; 
        }

    pumps = new Pump[numPumps]; 
    this.numPumps = numPumps; 
    topPump = numPumps - 1; 

    for (int p = 0; p < numPumps; p++) 
        pumps[p] =new Pump(); 
    }

    /**
    * aPumpisAvailable: return true/false according to whether at least one 
    * pump is free for use.
    * @return boolean
    */
    
    public boolean aPumpIsAvailable(){
            return topPump >= 0; 
        }

    /** 
    * getNumberOfPumps: return the number of pumps in the pump stand. 
    * (This method is needed when statistics are gathered.) 
    * @return int 
    */

    public int getNumberOfPumps (){
        return numPumps; 
    }

    /** 
    * releasePump: put pump p back in the stock of available pumps. 
    * @param p aim.Pump 
    */

    public void releasePump (Pump p) {
        if (topPump >= numPumps) { 
            System.out.println ("Error! attempt to release a free pump?"); 
            return; 
        }
        pumps[++topPump]= p; 
    }

    /** 
    takeAvailablePump: take a pump from the set of free pumps, and return that 
    pump. 
    * @return sim.Pump 
    */

    public Pump takeAvailablePump (){
        if (topPump < 0){
            System.out.println ("Error! no pump available when needed"); 
            return null; 
        }
    return pumps[topPump--]; 
    }

}
