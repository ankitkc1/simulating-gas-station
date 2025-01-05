package com.gas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class EventListTest {

    @Test
    void testEventInsertion() {
        EventList eventList = new EventList();

        // Create and insert events
        Arrival event1 = new Arrival(2.0);
        Arrival event2 = new Arrival(1.0);
        Arrival event3 = new Arrival(3.0);

        eventList.insert(event1);
        eventList.insert(event2);
        eventList.insert(event3);

        // Verify the first event in the list has the earliest time (event2)
        assertEquals(event2, eventList.getFirstEvent(), "First event should be event2.");
    }

    @Test
    void testTakeNextEvent() {
        EventList eventList = new EventList();

        // Create and insert events
        Arrival event1 = new Arrival(2.0);
        Arrival event2 = new Arrival(1.0);
        Arrival event3 = new Arrival(3.0);

        eventList.insert(event1);
        eventList.insert(event2);
        eventList.insert(event3);

        // Take events one by one and verify order
        Arrival firstTakenEvent = (Arrival) eventList.takeNextEvent();
        assertEquals(event2, firstTakenEvent, "First taken event should be event2.");
        
        Arrival secondTakenEvent = (Arrival) eventList.takeNextEvent();
        assertEquals(event1, secondTakenEvent, "Second taken event should be event1.");
        
        Arrival thirdTakenEvent = (Arrival) eventList.takeNextEvent();
        assertEquals(event3, thirdTakenEvent, "Third taken event should be event3.");
    }

    @Test
    void testTakeFromEmptyList() {
        EventList eventList = new EventList();
        
        //  an event from the empty list
        com.gas.Event event = eventList.takeNextEvent();
        
        // Verify that the event is null (since the list is empty)
        assertNull(event, "Taking from an empty event list should return null.");
    }
}
