package com.gas;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PumpStandTest {

    @Test
    void testPumpAvailability() {
        PumpStand pumpStand = new PumpStand(3);  // PumpStand with 3 pumps
        
        //check if pump is available
        assertTrue(pumpStand.aPumpIsAvailable(), "Pump should be available initially.");
    }

    @Test
    void testPumpTakeAndRelease() {
        PumpStand pumpStand = new PumpStand(3); 
        
        // Take a pump from the stand
        Pump takenPump = pumpStand.takeAvailablePump();
        assertNotNull(takenPump, "A pump should be taken when available.");
        
        // After taking a pump, one should not be available
        assertTrue(pumpStand.aPumpIsAvailable(), "There should still be pumps available.");
        
        // Release the taken pump back to the stand
        pumpStand.releasePump(takenPump);
        
        // After releasing, a pump should be available again
        assertTrue(pumpStand.aPumpIsAvailable(), "After releasing, a pump should be available.");
    }
}