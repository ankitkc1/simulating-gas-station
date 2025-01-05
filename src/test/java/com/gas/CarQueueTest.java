package com.gas;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class CarQueueTest {

    @Test
    void testInsertAndQueueSize() {
        
        Random mockRandom = new Random(42);  
        sim.litreStream = mockRandom;
        
        CarQueue queue = new CarQueue();
        
        // Create sample cars
        Car car1 = new Car();
        Car car2 = new Car();
        
        // Test that the queue size is 0 initially
        assertEquals(0, queue.getQueueSize(), "Queue size should be 0 initially.");
        
        // Insert first car
        queue.insert(car1);
        
        // Test queue size after inserting one car
        assertEquals(1, queue.getQueueSize(), "Queue size should be 1 after inserting a car.");
        
        // Insert second car
        queue.insert(car2);
        
        // Test queue size after inserting second car
        assertEquals(2, queue.getQueueSize(), "Queue size should be 2 after inserting another car.");
    }

    @Test
    void testTakeFirstCar() {
        
        Random mockRandom = new Random(42); 
        sim.litreStream = mockRandom;
        
        CarQueue queue = new CarQueue();
        
        // Create cars
        Car car1 = new Car();
        Car car2 = new Car();
        
        // Insert cars into the queue
        queue.insert(car1);
        queue.insert(car2);
        
        // Test taking first car from the queue
        Car takenCar = queue.takeFirstCar();
        assertNotNull(takenCar, "Taken car should not be null.");
        assertEquals(car1, takenCar, "The car taken should be the first car inserted.");
        
        // Test queue size after taking one car
        assertEquals(1, queue.getQueueSize(), "Queue size should be 1 after taking one car.");
        
        // Take the second car
        takenCar = queue.takeFirstCar();
        assertNotNull(takenCar, "Taken car should not be null.");
        assertEquals(car2, takenCar, "The car taken should be the second car inserted.");
        
        // Test if the queue is empty after taking all cars
        assertEquals(0, queue.getQueueSize(), "Queue size should be 0 after all cars are taken.");
    }
}