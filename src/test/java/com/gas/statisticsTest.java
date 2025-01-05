package com.gas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class statisticsTest {

    @Test
    void testSimulationTimePerArrival() {
        //  initial values for simulation time and arrivals
        double simulationTime = 100.0;
        int totalArrivals = 25;

        // calculation for simulation time per arrival
        double simulationTimePerArrival = simulationTime / totalArrivals;

        // Assert if the result is correct
        assertEquals(4.0, simulationTimePerArrival, "Simulation time per arrival is incorrect.");
    }

    @Test
    void testAverageLitresPerArrival() {
        // initial values for total litres sold and missed and the number of arrivals
        double totalLitresSold = 200.0;
        double totalLitresMissed = 50.0;
        int totalArrivals = 25;

        //calculation for average litres per arrival
        double averageLitresPerArrival = (totalLitresSold + totalLitresMissed) / totalArrivals;

        // Assert if the result is correct
        assertEquals(10.0, averageLitresPerArrival, "Average litres per arrival is incorrect.");
    }
}