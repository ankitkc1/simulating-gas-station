# Gas Station Simulation

This project simulates the operations of a gas station, including handling cars, pumps, events, and queues. The system is built using Java and utilizes Maven for build management and dependency resolution.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/ankitkc1/simulating-gas-station
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Application

1. To run the main simulation:
   ```bash
   mvn exec:jav
   '''
2. To run the test suite:
```bash
mvn test
```

## Project Structure

```
src/
├── main/
│   ├── java/com/gas/
│   │   ├── Sim.java          # Main simulation entry point
│   │   ├── EventList.java    # Event handling and scheduling
│   │   ├── PumpStand.java    # Pump management logic
│   │   └── ...               # Other classes
├── test/
│   └── java/com/gas/
│       ├── PumpTest.java     # Unit tests for Pump class
│       ├── EventListTest.java# Unit tests for EventList class
│       └── ...                #other test class
```
