package com.gas;

public class statistics {
    //The explicit initializations are not needed, but improve clarity. 
    private int totalArrivals = 0; 
    private int customersServed = 0; 
    private int balkingCustomers = 0; 
    private double totalLitresSold = 0.0; 
    private double totalLitresMissed = 0.0; 
    private double totalWaitingTime = 0.0; 
    private double totalServiceTime = 0.0; 
    
    /** 
    * Constructor. 
    */
    public statistics(){ 
        printHeaders(); 
    }
    
    /** 
    * accumBalk: record and count a lost sale. 
    * @pararn litres double 
    */
    public void accumBalk (double litres){
    balkingCustomers += 1; 
    totalLitresMissed += litres; 
    } 
    
    /** 
    * accwnSale: record and count a sale. 
    * @pararn litres double 
    */
    public void accumSale (double litres) { 
    customersServed += 1; 
    totalLitresSold += litres;
    } 
    /** 
    * accumserviceTime: record a customer's .... service time. 
    * @pararn interval double
    */
    public void accumServiceTime (double interval) { 
        totalServiceTime += interval;
    }
        /**
        * accumWaitingTime: record a customer's waiting time. 
        * @param interval double 
        */
    public void accumWaitingTime (double interval) { 
        totalWaitingTime += interval; 
    }

    /**
        * countArrival: record an arrival.
        */
    public void countArrival () { 
        totalArrivals += 1; 
    }
    
    /**
        * fmtDbl: convert a double to a string of a specified width representing 
        * the number rounded to the specified nwnber of digits. The string 
        * returned is padded by blanks on the left if necessary. If it is too long, 
        * it is not changed. If it is out of range for the 11int11 type, strange 
        * results will be returned. 
        * @return java.lang.Strina 
        * @param number double 
        • @param width int 
        * @param precision int 
    */
    public static String fmtDbl (double number, int width, int precision) { 
        // round and convert to string without decimal point 
        double scale = 1; 
        for (int i = 0; i < precision; i++) 
            scale *= 10; 
        String result = " " + (int) (number*scale + 0.5); 
        
        //insert decimal point and leading zero if necessay 
        if (precision > 0) { 
            for (int i = result.length(); i < precision + 1; i++) 
                result = "0" + result; 
            int insertPos = result.length() - precision; 
                //where the decimal point goes 
            result = result.substring (0, insertPos) + "." + result.substring (insertPos); 
        }

        //pad with blanks if necessary 
        for (int i= result.length(); i < width; i++) 
            result = " " + result; 
        return result; 
    }

        /**
        * fmtint: convert an int to a string of a specified width. 
        * The string returned is padded by blanks on the left if necessary. 
        * If it is too long, it is not changed .
        * @return java.lang.string
        * @param number int 
        * @param width int  
        */

    private static String fmtInt (int number, int width) { 
        String result = "" + number;
        for (int i= result.length(); i< width; i++) 
            result = " " + result; 
        return result;
    }
        //printHeaders: print column titles for the statistics summaries. 
        
    private static void printHeaders () { 
        System.out.println ("Current   Total   NoQueue     Car->Car    Average      Number      Average     Pump    Total       Loss");
        System.out.println (" Time      Cars    Fraction    Time        Litres      Balked      Wait        Usage   Profit      Profit");  
        for (int i = 0; i < 110; i++) 
            System.out.print ("-"); 
        System.out.println (""); 
    }
            
        /** snapshot: print a summary of the statistics so far. 
        */
    public void snapshot () { 
        System.out.print (fmtDbl (sim.simulationTime, 8, 0)); 
        System.out.print (fmtInt (totalArrivals, 7)); 
        System.out.print (fmtDbl (sim.carQueue.getEmptyTime()/sim.simulationTime, 8, 3));
       
        
        if (totalArrivals > 0) { 
            System.out.print (fmtDbl (sim.simulationTime/totalArrivals, 9, 3)); 
            System.out.print (fmtDbl ((totalLitresSold + totalLitresMissed)/ totalArrivals, 9 , 3)); 
        }
        else 
            System.out.print (" Unknown Unknown ");

        System.out.print (fmtInt (balkingCustomers, 7));
        if (customersServed > 0) 
            System.out.print (fmtDbl (totalWaitingTime/customersServed, 9, 3)); 
        else 
            System.out.print (" Unknown " ); 
        
        System.out.print (fmtDbl (totalServiceTime / (sim.pumpStand.getNumberOfPumps() * sim.simulationTime), 7, 3)); 
        System.out.print (fmtDbl (totalLitresSold * sim.profit - sim.pumpCost * sim.pumpStand.getNumberOfPumps(), 9, 2)); 
        System.out.print (fmtDbl (totalLitresMissed * sim.profit, 7, 2)); 
        
        System.out.println ( "");
    }
}
