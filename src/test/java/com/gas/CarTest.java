package com.gas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void testSetArrivalTime() {

        sim.litreStream = new java.util.Random(200); 
        Car car = new Car(); 

        // keeping arrival time to a specific value
        double expectedArrivalTime = 5.0;
        car.setArrivalTime(expectedArrivalTime);

        // Assert if the arrival time is set correctly
        assertEquals(expectedArrivalTime, car.getArrivalTime(), "Arrival time should be set correctly.");
    }
}
