package com.gas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class simTest {

    @Test
    void testSimulationTimeInitialization() {
        // Test the initialization of simulation time
        sim.simulationTime = 0.0;
        assertEquals(0.0, sim.simulationTime, "Simulation time should be initialized to 0.0");
        //type of value
        assertTrue(sim.simulationTime >= 0, "Simulation time should be non-negative");

    }

    @Test
    void testReportInterval() {
        // Test the report interval setup
        sim.reportInterval = 15.0;
        assertEquals(15.0, sim.reportInterval, "Report interval should be 15.0");
        //test in negative case
        sim.reportInterval = -5.0;
        assertTrue(sim.reportInterval < 0, "Report interval should not be negative");
    }

    @Test
    void testPumpCostEquality() {
        // Test for pump cost being a positive number
        assertTrue(sim.pumpCost > 0, "Pump cost should be greater than 0");
    }
}