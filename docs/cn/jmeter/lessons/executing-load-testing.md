# Lesson 10: Executing Load Testing

## Goal
The goal of this lesson is to configure and execute load testing in JMeter.

## Steps

### 10.1. Adjusting Thread Settings
1. **Load Testing Configuration**
    - Click on the **Thread Group**.
    - Set the **Number of Threads** (users), **Ramp-Up Period** (seconds), and **Loop Count** as needed for your load test.

### 10.2. Adding an Aggregate Report Listener
1. **Summary Report**
    - Right-click on the **Simple Controller**.
    - Select **Add > Listener > Aggregate Report**.
    - Disable the **View Results Tree** listener to improve performance during load testing.

### 10.3. Running the Load Test
1. **Execution**
    - Click **Run > Start** to begin the load test.
    - View the summarized results in the **Aggregate Report** listener.

---

# [Next: Analyzing Test Results](analyzing-test-results.md)